package br.upe.acs.controlador.respostas;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Protocolo;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

@Getter
public class ProtocoloResposta {

	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private int semestre;
	
	private int qtdCertificados;
	
	private String token;
	
	private byte[] protocoloArquivo;
	
	private List<CertificadoResposta> certificados;

	public ProtocoloResposta(Protocolo protocolo) {
		super();
		this.id = protocolo.getId();
		this.data = protocolo.getData();
		this.semestre = protocolo.getSemestre();
		this.qtdCertificados = protocolo.getQtdCertificados();
		this.token = protocolo.getToken();
		this.protocoloArquivo = protocolo.getProtocoloArquivo();
		this.certificados = converterCertificados(protocolo.getCertificados());
	}
	
	private List<CertificadoResposta> converterCertificados(List<Certificado> certificados) {
		List<CertificadoResposta> resposta = certificados.stream()
				.map(certificado -> new CertificadoResposta(certificado)).collect(Collectors.toList());
		
		return resposta;
	}
}
