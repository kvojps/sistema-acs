package br.upe.acs.controller.responses;

import br.upe.acs.model.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
public class UsuarioResposta {

	private final Long id;

	private final String nomeCompleto;

	private final String matricula;

	private final String telefone;

	private final String email;

	private final List<String> perfis;

	private final CourseResponse curso;

	private final int periodo;

	private final boolean verificado;

	public UsuarioResposta(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.matricula = usuario.getMatricula();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.perfis = usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		this.curso = new CourseResponse(usuario.getCurso());
		this.periodo = usuario.getPeriodo();
		this.verificado = usuario.isVerificado();
	}
}
