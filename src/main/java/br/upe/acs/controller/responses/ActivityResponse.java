package br.upe.acs.controller.responses;

import br.upe.acs.model.Activity;
import br.upe.acs.model.enums.AxleEnum;
import lombok.Getter;

@Getter
public class ActivityResponse {

    private final Long id;

    private final AxleEnum axle;

    private final String description;

    private final String evaluationMethods;

    private final Integer workloadCertificate;

    private final int workLoadMax;

    public ActivityResponse(Activity activity) {
        super();
        this.id = activity.getId();
        this.axle = activity.getAxle();
        this.description = activity.getDescription();
        this.workLoadMax = activity.getWorkloadMax();
        this.evaluationMethods = activity.getEvaluationMethods();
        this.workloadCertificate = activity.getWorkloadCertificate();
    }
}
