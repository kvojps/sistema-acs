package br.upe.acs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO {

	private String cep;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String UF;
	
	private int numero;

	private String complemento;
}