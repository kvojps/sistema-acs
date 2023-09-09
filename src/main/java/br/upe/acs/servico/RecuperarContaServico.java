package br.upe.acs.servico;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static br.upe.acs.servico.ControleAcessoServico.validarSenha;

@Service
@RequiredArgsConstructor
public class RecuperarContaServico {

    private final UsuarioRepositorio usuarioRepositorio;

    private final JwtService jwtService;

    private final EmailServico emailServico;

    private final PasswordEncoder passwordEncoder;

    public void recuperarConta(String email) {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);

        if (usuario.isPresent()) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("recuperacao", true);
            String token = jwtService.generateToken(claims, usuario.get(), 1000 * 60 * 15);
            CompletableFuture.runAsync(() -> emailServico.enviarEmailDeRecuperacaoDeSenha(usuario.get(), token));
        }
    }

    public void alterarSenha(String token, String novaSenha) throws AcsExcecao {
        boolean isTokenDeRecuperacao;

        try {
            isTokenDeRecuperacao = jwtService.extractClaim(token,
                    (claims -> claims.get("recuperacao", Boolean.class)));
        } catch (Exception e) {
            throw new AcsExcecao("Token inválido!");
        }

        if (!isTokenDeRecuperacao) {
            throw new AcsExcecao("Token inválido!");
        }

        String email = jwtService.extractUsername(token);

        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);

        if (usuario.isEmpty()) {
            throw new AcsExcecao("Token inválido!");
        }

        validarSenha(novaSenha);

        usuario.get().setSenha(passwordEncoder.encode(novaSenha));

        usuarioRepositorio.save(usuario.get());
    }


}
