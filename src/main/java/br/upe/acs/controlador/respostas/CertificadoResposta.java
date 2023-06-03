package br.upe.acs.controlador.respostas;

import java.util.Date;

import br.upe.acs.dominio.Certificado;
import lombok.Getter;

@Getter
public class CertificadoResposta {
	
	private Long id;
	
	private String descricao;
	
	private Date data;
	
	private int horas;
	
	private int chMaxima;
	
	private int chTotal;
	
	private byte[] certificadoArquivo;

	public CertificadoResposta(Certificado certificado) {
		super();
		this.id = certificado.getId();
		this.descricao = certificado.getDescricao();
		this.data = certificado.getData();
		this.horas = certificado.getHoras();
		this.chMaxima = certificado.getChMaxima();
		this.chTotal = certificado.getChTotal();
		this.certificadoArquivo = certificado.getCertificado();
	}
	
	
}
