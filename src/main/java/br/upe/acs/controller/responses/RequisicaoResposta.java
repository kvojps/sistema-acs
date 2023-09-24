package br.upe.acs.controller.responses;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.model.Certificado;
import br.upe.acs.model.Requisicao;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import lombok.Getter;

@Getter
public class RequisicaoResposta {

	private final Long id;

	private final String idRequisicao;

	private final Date dataDeSubmissao;

	private final String token;

	private final boolean arquivada;
	
	private final RequisicaoStatusEnum requisicaoStatus;

	private final String observacao;

	private final float quantidadeDeHoras;

	private final List<CertificadoResposta> certificados;

	public RequisicaoResposta(Requisicao requisicao) {
		super();
		this.id = requisicao.getId();
		this.idRequisicao = requisicao.getIdRequisicao();
		this.dataDeSubmissao = requisicao.getDataDeSubmissao();
		this.token = requisicao.getToken();
		this.arquivada = requisicao.isArquivada();
		this.requisicaoStatus = requisicao.getStatusRequisicao();
		this.observacao = requisicao.getObservacao();
		this.quantidadeDeHoras = (float) requisicao.getCertificados().stream()
				.mapToDouble(Certificado::getCargaHoraria).sum();
		this.certificados = converterCertificados(requisicao.getCertificados());
	}
	

	private List<CertificadoResposta> converterCertificados(List<Certificado> certificados) {
		return certificados.stream()
				.map(CertificadoResposta::new)
				.sorted(Comparator.comparing(CertificadoResposta::getId))
				.collect(Collectors.toList());
	}
}