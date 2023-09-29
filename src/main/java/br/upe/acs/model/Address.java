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
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String cep;

	private String street;

	private String district;

	private String city;

	private String uf;

	private int number;

	@Column(nullable = true)
	private String complement;
	

	@OneToMany(mappedBy = "address")
	private List<Usuario> users;
	
}

