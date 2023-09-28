package br.upe.acs.controller.responses;

import java.util.Date;

import br.upe.acs.model.Certificado;
import br.upe.acs.model.enums.CertificadoStatusEnum;
import br.upe.acs.model.enums.AxleEnum;
import lombok.Getter;

@Getter
public class CertificadoResposta {
	
	private final Long id;
	
	private final String titulo;
	
	private final String observacao;
	
	private final Date dataInicial;

	private final Date dataFinal;
	
	private AxleEnum eixoAtividade;

	private String atividade;
	
	private final CertificadoStatusEnum statusCertificado;
	
	private final float cargaHoraria;

	public CertificadoResposta(Certificado certificado) {
		super();
		this.id = certificado.getId();
		this.titulo = certificado.getTitulo();
		this.observacao = certificado.getObservacao();
		this.dataInicial = certificado.getDataInicial();
		this.dataFinal = certificado.getDataFinal();
		if (certificado.getActivity() != null) {
			this.atividade = certificado.getActivity().getDescription();
			this.eixoAtividade = certificado.getActivity().getAxle();
		}
		this.cargaHoraria = certificado.getCargaHoraria();
		this.statusCertificado = certificado.getStatusCertificado();
	}
}
