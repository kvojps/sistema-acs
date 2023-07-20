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
	
	private final EixoEnum eixoAtividade;

	private final String atividade;
	
	private final CertificadoStatusEnum statusCertificado;
	
	private final int cargaHoraria;
	
	private final byte[] certificadoArquivo;

	public CertificadoResposta(Certificado certificado) {
		super();
		this.id = certificado.getId();
		this.titulo = certificado.getTitulo();
		this.observacao = certificado.getObservacao();
		this.dataInicial = certificado.getDataInicial();
		this.dataFinal = certificado.getDataFinal();
		this.atividade = certificado.getAtividade().getDescricao();
		this.eixoAtividade = certificado.getAtividade().getEixo();
		this.cargaHoraria = certificado.getCargaHoraria();
		this.certificadoArquivo = certificado.getCertificado();
		this.statusCertificado = certificado.getStatusCertificado();
	}
}
