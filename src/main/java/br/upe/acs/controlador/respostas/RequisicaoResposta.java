package br.upe.acs.controlador.respostas;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import lombok.Getter;

@Getter
public class RequisicaoResposta {

	private final Long id;

	private final Date dataDeSubmissao;

	private final String token;

	private final boolean arquivada;

	private final String observacao;

	private final float quantidadeDeHoras;

	private final List<CertificadoResposta> certificados;

	private RequisicaoStatusEnum requisicaoStatus;

	private byte[] requisicaoArquivo;

	public RequisicaoResposta(Requisicao requisicao) {
		super();
		this.id = requisicao.getId();
		this.dataDeSubmissao = requisicao.getDataDeSubmissao();
		this.token = requisicao.getToken();
		this.arquivada = requisicao.isArquivada();
		this.requisicaoArquivo = requisicao.getRequisicaoArquivoAssinada();
		this.requisicaoStatus = requisicao.getStatusRequisicao();
		this.observacao = requisicao.getObservacao();
		this.quantidadeDeHoras = (float) requisicao.getCertificados().stream()
				.mapToDouble(Certificado::getCargaHoraria).sum();
		this.certificados = converterCertificados(requisicao.getCertificados());

	}

	private List<CertificadoResposta> converterCertificados(List<Certificado> certificados) {
		return certificados.stream()
				.map(CertificadoResposta::new).collect(Collectors.toList());
	}
}