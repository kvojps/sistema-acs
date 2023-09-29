package br.upe.acs.controller.responses;

import br.upe.acs.model.User;
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

	public UsuarioResposta(User user) {
		this.id = user.getId();
		this.nomeCompleto = user.getFullName();
		this.matricula = user.getEnrollment();
		this.telefone = user.getTelephone();
		this.email = user.getEmail();
		this.perfis = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		this.curso = new CourseResponse(user.getCourse());
		this.periodo = user.getPeriod();
		this.verificado = user.isVerified();
	}
}
