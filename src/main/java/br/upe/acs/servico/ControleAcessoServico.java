package br.upe.acs.servico;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.EmailDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.dominio.enums.PerfilEnum;
import br.upe.acs.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ControleAcessoServico {

	private final UsuarioRepositorio repositorio;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	private final EmailServico emailServico;

	public AutenticacaoResposta cadastrarUsuario(RegistroDTO registro) {
		Usuario usuarioSalvar = new Usuario();

		usuarioSalvar.setEmail(registro.getEmail());
		usuarioSalvar.setPrimeiroNome(registro.getPrimeiroNome());
		usuarioSalvar.setUltimoNome(registro.getUltimoNome());
		usuarioSalvar.setSenha(passwordEncoder.encode(registro.getSenha()));
		usuarioSalvar.setPerfil(PerfilEnum.USUARIO);
		String codigoVerificacao = gerarCodigoVerificacao();
		usuarioSalvar.setCodigoVerificacao(codigoVerificacao);
		usuarioSalvar.setVerificado(false);

		repositorio.save(usuarioSalvar);

		CompletableFuture.runAsync(() -> {
			enviarEmail(registro, codigoVerificacao);
		});

		return gerarAutenticacaoResposta(usuarioSalvar);
	}

	public AutenticacaoResposta loginUsuario(LoginDTO login) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
		Usuario usuario = repositorio.findByEmail(login.getEmail()).orElseThrow();

		return gerarAutenticacaoResposta(usuario);
	}

	private AutenticacaoResposta gerarAutenticacaoResposta(Usuario usuario) {
		String jwtToken = jwtService.generateToken(usuario);
		AutenticacaoResposta autenticacaoResposta = new AutenticacaoResposta();
		autenticacaoResposta.setToken(jwtToken);

		return autenticacaoResposta;
	}

	private void enviarEmail(RegistroDTO registro, String codigoVerificacao) {
		EmailDTO email = new EmailDTO();

		email.setAssunto("Código de verificação - Sistema ACs UPE");
		email.setDestinatario(registro.getEmail());
		email.setMensagem(
				"Confirme seu email, envie esse código na página de verificação do sistema: " + codigoVerificacao);
		emailServico.enviarEmail(email);
	}

	private static String gerarCodigoVerificacao() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder codigo = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int indice = random.nextInt(caracteres.length());
			char caractere = caracteres.charAt(indice);
			codigo.append(caractere);
		}

		return codigo.toString();
	}
}
