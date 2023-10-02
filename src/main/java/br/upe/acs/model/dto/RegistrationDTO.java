package br.upe.acs.model.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record RegistrationDTO(String fullName, @CPF(message = "CPF invalid!") String cpf, String enrollment,
							  int period, String phone, @Email(message = "Email invalid!") String email,
							  String password, String cep, String street, String district, String city, String uf,
							  String complement, int number, Long courseId) {}
