package br.upe.acs.controlador.respostas;

import lombok.Getter;

@Getter
public class ArquivoResposta {
    private final byte[] arquivo;

    public ArquivoResposta(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
