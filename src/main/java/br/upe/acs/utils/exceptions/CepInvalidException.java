package br.upe.acs.utils.exceptions;

public class CepInvalidException extends RuntimeException {

    public CepInvalidException(String message) {
        super("Error(s): " + message);
    }
}
