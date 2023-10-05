package br.upe.acs.controller.responses;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.model.Certificate;
import br.upe.acs.model.Request;
import br.upe.acs.model.enums.RequestStatusEnum;
import lombok.Getter;

@Getter
public class RequestResponse {

	private final Long id;
	private final String semanticId;
	private final Date sentAt;
	private final String token;
	private final boolean archived;
	private final RequestStatusEnum status;
	private final String note;
	private final float workload;
	private final List<CertificateResponse> certificates;

	public RequestResponse(Request request) {
		super();
		this.id = request.getId();
		this.semanticId = request.getSemanticId();
		this.sentAt = request.getSentAt();
		this.token = request.getToken();
		this.archived = request.isArchived();
		this.status = request.getStatus();
		this.note = request.getNote();
		this.workload = (float) request.getCertificates().stream()
				.mapToDouble(Certificate::getWorkload).sum();
		this.certificates = convertCertificates(request.getCertificates());
	}
	

	private List<CertificateResponse> convertCertificates(List<Certificate> certificates) {
		return certificates.stream()
				.map(CertificateResponse::new)
				.sorted(Comparator.comparing(CertificateResponse::getId))
				.collect(Collectors.toList());
	}
}