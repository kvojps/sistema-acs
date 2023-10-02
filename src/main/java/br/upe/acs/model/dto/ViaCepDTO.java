package br.upe.acs.model.dto;

public record ViaCepDTO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
                               String ibge, String gia, String ddd, String siafi) {}