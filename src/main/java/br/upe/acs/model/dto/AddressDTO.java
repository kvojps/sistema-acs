package br.upe.acs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {

	private String cep;

	private String street;

	private String district;
	
	private String city;
	
	private String uf;

	private int number;

	private String complement;

}
