package br.upe.acs.controlador.respostas;

import java.util.Date;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import br.upe.acs.dominio.enums.EixoEnum;
import lombok.Getter;

@Getter
public class CertificadoResposta {
	
	private final Long id;
	
	private final String titulo;
	
	private final String observacao;
	
	private final Date dataInicial;

	private final Date dataFinal;
	
	private EixoEnum eixoAtividade;

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
		if (certificado.getAtividade() != null) {
			this.atividade = certificado.getAtividade().getDescricao();
			this.eixoAtividade = certificado.getAtividade().getEixo();
		}
		this.cargaHoraria = certificado.getCargaHoraria();
		this.statusCertificado = certificado.getStatusCertificado();
	}
}
