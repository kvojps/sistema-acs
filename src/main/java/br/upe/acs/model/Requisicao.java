package br.upe.acs.model;

import java.util.Date;
import java.util.List;

import br.upe.acs.model.enums.RequisicaoStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Requisicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String idRequisicao;
	
	@Temporal(TemporalType.DATE)
	private Date criacao;
	
	@Column(columnDefinition = "TEXT")
	private String observacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDeSubmissao;

	private String token;

	private boolean arquivada;
	
	private byte[] requisicaoArquivoAssinada;
	
	@Enumerated(EnumType.STRING)
	private RequisicaoStatusEnum statusRequisicao;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "requisicao",cascade = CascadeType.REMOVE)
	private List<Certificado> certificados;
}
