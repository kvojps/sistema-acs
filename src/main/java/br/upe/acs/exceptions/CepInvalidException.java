package br.upe.acs.exceptions;

public class CepInvalidException extends RuntimeException {

    public CepInvalidException(String mensagem) {
        super(mensagem);
    }
}
