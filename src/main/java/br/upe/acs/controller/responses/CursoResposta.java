package br.upe.acs.controller.responses;

import br.upe.acs.model.Curso;
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
