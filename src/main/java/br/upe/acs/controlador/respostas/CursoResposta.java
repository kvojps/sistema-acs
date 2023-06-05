package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Requisicao;
import lombok.Getter;

@Getter
public class CursoResposta {

	private Long id;

	private String nome;

	private List<RequisicaoResposta> requisicoes;

	public CursoResposta(Curso curso) {
		super();
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.requisicoes = converterRequisicoes(curso.getRequisicoes());
	}

	private List<RequisicaoResposta> converterRequisicoes(List<Requisicao> requisicoes) {
		List<RequisicaoResposta> resposta = requisicoes.stream().map(requisicao -> new RequisicaoResposta(requisicao))
				.collect(Collectors.toList());

		return resposta;
	}
}
