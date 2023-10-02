package br.upe.acs.model.dto;

import br.upe.acs.model.enums.AxleEnum;

public record ActivityDTO(AxleEnum axle, String description, String evaluationMethods, Integer workloadCertificate,
                          int workloadMax) {}
