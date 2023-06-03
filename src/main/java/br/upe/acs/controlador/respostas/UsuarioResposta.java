package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.PerfilEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class UsuarioResposta {
	
	private Long id;
	
	private String primeiroNome;
	
	private String ultimoNome;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	public UsuarioResposta(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.primeiroNome = usuario.getPrimeiroNome();
		this.ultimoNome = usuario.getUltimoNome();
		this.email = usuario.getEmail();
		this.perfil = usuario.getPerfil();
	}
}
