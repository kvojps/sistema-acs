package br.upe.acs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificateDTO {

	private String title;
		
	private String startDate;

	private String endDate;
	
	private float workload;
	
	private Long activityId;
}
