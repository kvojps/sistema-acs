package br.upe.acs.controller.responses;

import lombok.Getter;

@Getter
public class ArquivoResposta {
    private final byte[] arquivo;

    public ArquivoResposta(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
