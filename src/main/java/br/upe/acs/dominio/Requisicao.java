package br.upe.acs.dominio;

import java.util.Date;
import java.util.List;

import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requisicao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int semestre;

	private int qtdCertificados;

	private String token;

	private byte[] requisicaoArquivoAssinada;
	
	@Enumerated(EnumType.STRING)
	private RequisicaoStatusEnum statusRequisicao;

	@ManyToOne
	private Aluno aluno;

	@ManyToOne
	private Curso curso;

	@OneToMany(mappedBy = "requisicao")
	private List<Certificado> certificados;
}
