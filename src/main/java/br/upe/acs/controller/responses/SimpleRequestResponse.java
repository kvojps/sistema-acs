package br.upe.acs.controller.responses;

import br.upe.acs.model.Certificate;
import br.upe.acs.model.Request;
import br.upe.acs.model.enums.RequestStatusEnum;
import lombok.Getter;

import java.util.Date;

@Getter
public class SimpleRequestResponse {

    private final Long id;

    private final String identifier;

    private final RequestStatusEnum status;

    private final Date sentIn;

    private final float workload;

    public SimpleRequestResponse(Request request) {
        this.id = request.getId();
        this.identifier = request.getSemanticId();
        this.status = request.getStatus();
        this.sentIn = request.getSentAt();
        this.workload = (float) request.getCertificates().stream()
                .mapToDouble(Certificate::getWorkload).sum();
    }
}