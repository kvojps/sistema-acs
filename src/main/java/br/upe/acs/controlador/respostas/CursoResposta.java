package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Requisicao;
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
