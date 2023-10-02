package br.upe.acs.model.dto;

public record AddressDTO(String cep, String street, String district, String city, String uf, int number,
                         String complement) {}