package br.upe.acs.model;

import java.util.List;

import br.upe.acs.model.enums.AxleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AxleEnum axle;

	private String description;

	private String evaluationMethods;

	private int workloadMax;

    private Integer workloadCertificate;

	@OneToMany(mappedBy = "activity")
	private List<Certificate> certificates;

}
