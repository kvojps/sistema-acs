package br.upe.acs.controlador.respostas;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

@Getter
public class RequisicaoResposta {

	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private int semestre;
	
	private int qtdCertificados;
	
	private String token;
	
	private byte[] requisicaoArquivo;
	
	private List<CertificadoResposta> certificados;

	public RequisicaoResposta(Requisicao requisicao) {
		super();
		this.id = requisicao.getId();
		this.data = requisicao.getData();
		this.semestre = requisicao.getSemestre();
		this.qtdCertificados = requisicao.getQtdCertificados();
		this.token = requisicao.getToken();
		this.requisicaoArquivo = requisicao.getRequisicaoArquivo();
		this.certificados = converterCertificados(requisicao.getCertificados());
	}
	
	private List<CertificadoResposta> converterCertificados(List<Certificado> certificados) {
		List<CertificadoResposta> resposta = certificados.stream()
				.map(certificado -> new CertificadoResposta(certificado)).collect(Collectors.toList());
		
		return resposta;
	}
}
