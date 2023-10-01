package br.upe.acs.model;

import java.util.Date;
import java.util.List;

import br.upe.acs.model.enums.RequestStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String semanticId;
	
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Column(columnDefinition = "TEXT")
	private String note;
	
	@Temporal(TemporalType.DATE)
	private Date sentAt;

	private String token;

	private boolean archived;
	
	private byte[] signedFile;
	
	@Enumerated(EnumType.STRING)
	private RequestStatusEnum status;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "request",cascade = CascadeType.REMOVE)
	private List<Certificate> certificates;
}
