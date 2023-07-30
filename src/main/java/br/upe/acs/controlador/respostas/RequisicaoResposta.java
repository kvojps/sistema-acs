package br.upe.acs.controlador.respostas;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class RequisicaoResposta {

	private final Long id;

	private final RequisicaoStatusEnum status;

	private final Date data;
	
	private final String token;

	private final String observacao;
	
	private final List<Long> certificados;

	private final float QuantidadeDeHoras;

	public RequisicaoResposta(Requisicao requisicao) {
		super();
		this.id = requisicao.getId();
		this.data = requisicao.getDataDeSubmissao();
		this.token = requisicao.getToken();
		this.status = requisicao.getStatusRequisicao();
		this.observacao = requisicao.getObservacao();
		this.certificados =requisicao.getCertificados().stream().map(Certificado::getId).toList();
		QuantidadeDeHoras = requisicao.getCertificados().stream().mapToInt(Certificado::getCargaHoraria).sum();
	}

}
