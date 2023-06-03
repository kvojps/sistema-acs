package br.upe.acs.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDTO {
	
	private String primeiroNome;
	
	private String ultimoNome;
	
	private String email;
	
	private String senha;
}
