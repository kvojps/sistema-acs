package br.upe.acs.controller.responses;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.model.Certificado;
import br.upe.acs.model.Request;
import br.upe.acs.model.enums.RequestStatusEnum;
import lombok.Getter;

@Getter
public class RequestResponse {

	private final Long id;

	private final String identifier;

	private final Date sentIn;

	private final String token;

	private final boolean arquived;
	
	private final RequestStatusEnum status;

	private final String note;

	private final float workload;

	private final List<CertificadoResposta> certificates;

	public RequestResponse(Request request) {
		super();
		this.id = request.getId();
		this.identifier = request.getIdentifier();
		this.sentIn = request.getSentIn();
		this.token = request.getToken();
		this.arquived = request.isArchived();
		this.status = request.getStatus();
		this.note = request.getNote();
		this.workload = (float) request.getCertificates().stream()
				.mapToDouble(Certificado::getCargaHoraria).sum();
		this.certificates = converterCertificados(request.getCertificates());
	}
	

	private List<CertificadoResposta> converterCertificados(List<Certificado> certificates) {
		return certificates.stream()
				.map(CertificadoResposta::new)
				.sorted(Comparator.comparing(CertificadoResposta::getId))
				.collect(Collectors.toList());
	}
}