package br.upe.acs.utils.exceptions;

public class InvalidRegisterException extends RuntimeException {

    public InvalidRegisterException(String message) {
        super("Error(s): " + message);
    }
}
