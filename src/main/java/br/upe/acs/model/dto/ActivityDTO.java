package br.upe.acs.model.dto;

import br.upe.acs.model.enums.AxleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityDTO {

	private AxleEnum axle;
	private String description;
	private String evaluationMethods;
	private Integer workloadCertificate;
	private int workloadMax;
}
