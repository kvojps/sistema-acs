package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Curso;
import lombok.Getter;

@Getter
public class CursoResposta {

	private final Long id;

	private final String nome;

	public CursoResposta(Curso curso) {
		super();
		this.id = curso.getId();
		this.nome = curso.getNome();
	}
}
