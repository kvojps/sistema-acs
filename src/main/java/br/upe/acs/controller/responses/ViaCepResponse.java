package br.upe.acs.controller.responses;

import br.upe.acs.model.dto.ViaCepDTO;
import lombok.Getter;

@Getter
public class ViaCepResponse {
    private final String cep;

    private final String street;

    private final String district;

    private final String city;

    private final String uf;

    public ViaCepResponse(ViaCepDTO viaCepDTO) {
        super();
        this.cep = viaCepDTO.cep();
        this.street = viaCepDTO.logradouro();
        this.district = viaCepDTO.bairro();
        this.city = viaCepDTO.localidade();
        this.uf = viaCepDTO.uf();
    }
}
