package br.upe.acs.model;

import java.util.Date;

import br.upe.acs.model.enums.CertificateStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "certificates")
@Data
@NoArgsConstructor
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	
	@Column(columnDefinition = "TEXT")
	private String note;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private float workload;
	
	private byte[] certificate;
	
	@Enumerated(EnumType.STRING)
	private CertificateStatusEnum status;
	
	@ManyToOne
	private Request request;
	
	@ManyToOne
	private Activity activity;

}
