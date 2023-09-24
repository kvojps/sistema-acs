package br.upe.acs.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String cep;

	private String rua;

	private String bairro;

	private String cidade;

	private String UF;

	private int numero;

	@Column(nullable = true)
	private String complemento;
	

	@OneToMany(mappedBy = "endereco")
	private List<Usuario> usuarios;
	
}

