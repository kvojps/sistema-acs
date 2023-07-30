package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Requisicao;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioResposta {

	private final Long id;

	private final String nomeCompleto;

	private final String matricula;

	private final String telefone;

	private final String email;

	private final List<String> perfis;

	private final CursoResposta curso;

	private final int periodo;

	private final boolean verificado;

	public UsuarioResposta(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.matricula = usuario.getMatricula();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.perfis = usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		this.curso = new CursoResposta(usuario.getCurso());
		this.periodo = usuario.getPeriodo();
		this.verificado = usuario.isVerificado();
	}
}
