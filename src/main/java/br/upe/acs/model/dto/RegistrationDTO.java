package br.upe.acs.model.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationDTO {
	
	private String fullName;

	@CPF(message = "CPF invalid!")
	private String cpf;
	
	private String enrollment;
	
	private int period;
	
	private String telephone;

	@Email(message = "Email invalid!")
	private String email;
	
	private String password;
	
	private String cep;
	
	private String street;
	
	private String district;
	
	private String city;
	
	private String uf;

	private String complement;
	
	private int number;
	
	private Long courseId;

}
