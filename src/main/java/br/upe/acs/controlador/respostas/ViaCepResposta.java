package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.dto.ViaCepDTO;
import lombok.Getter;

@Getter
public class ViaCepResposta {
    private final String cep;

    private final String rua;

    private final String bairro;

    private final String cidade;

    private final String UF;

    public ViaCepResposta(ViaCepDTO viaCepDTO) {
        super();
        this.cep = viaCepDTO.getCep();
        this.rua = viaCepDTO.getLogradouro();
        this.bairro = viaCepDTO.getBairro();
        this.cidade = viaCepDTO.getLocalidade();
        UF = viaCepDTO.getUf();
    }
}
