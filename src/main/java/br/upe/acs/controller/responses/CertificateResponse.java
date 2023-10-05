package br.upe.acs.controller.responses;

import java.util.Date;

import br.upe.acs.model.Certificate;
import br.upe.acs.model.enums.CertificateStatusEnum;
import br.upe.acs.model.enums.AxleEnum;
import lombok.Getter;

@Getter
public class CertificateResponse {
	
	private final Long id;
	private final String title;
	private final String note;
	private final Date startDate;
	private final Date endDate;
	private AxleEnum axle;
	private String activity;
	private final CertificateStatusEnum status;
	private final float workload;

	public CertificateResponse(Certificate certificate) {
		super();
		this.id = certificate.getId();
		this.title = certificate.getTitle();
		this.note = certificate.getNote();
		this.startDate = certificate.getStartDate();
		this.endDate = certificate.getEndDate();
		if (certificate.getActivity() != null) {
			this.activity = certificate.getActivity().getDescription();
			this.axle = certificate.getActivity().getAxle();
		}
		this.workload = certificate.getWorkload();
		this.status = certificate.getStatus();
	}
}
