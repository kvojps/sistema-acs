package br.upe.acs.servico;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.dominio.enums.PerfilEnum;
import br.upe.acs.dominio.respostas.AutenticacaoResposta;
import br.upe.acs.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ControleAcessoServico {

	private final UsuarioRepositorio repositorio;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	public AutenticacaoResposta cadastrarUsuario(RegistroDTO registro) {
		Usuario usuarioSalvar = new Usuario();
		
		usuarioSalvar.setEmail(registro.getEmail());
		usuarioSalvar.setPrimeiroNome(registro.getPrimeiroNome());
		usuarioSalvar.setUltimoNome(registro.getUltimoNome());
		usuarioSalvar.setSenha(passwordEncoder.encode(registro.getSenha()));
		usuarioSalvar.setPerfil(PerfilEnum.USUARIO);

		repositorio.save(usuarioSalvar);

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
}
