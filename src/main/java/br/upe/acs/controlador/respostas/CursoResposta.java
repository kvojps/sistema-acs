package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Protocolo;
import lombok.Getter;

@Getter
public class CursoResposta {

	private Long id;

	private String nome;

	private List<ProtocoloResposta> protocolos;

	public CursoResposta(Curso curso) {
		super();
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.protocolos = converterProtocolos(curso.getProtocolos());
	}

	private List<ProtocoloResposta> converterProtocolos(List<Protocolo> protocolos) {
		List<ProtocoloResposta> resposta = protocolos.stream().map(protocolo -> new ProtocoloResposta(protocolo))
				.collect(Collectors.toList());

		return resposta;
	}
}
