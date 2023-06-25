package br.upe.acs.dominio;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certificado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private int horas;
	
	private int chMaxima;
	
	private int chTotal;
	
	private byte[] certificado;
	
	@ManyToOne
	private Requisicao requisicao;
	
	@ManyToOne
	private Atividade atividade;
}
