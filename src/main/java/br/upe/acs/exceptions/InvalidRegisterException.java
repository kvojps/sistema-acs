package br.upe.acs.exceptions;

public class InvalidRegisterException extends RuntimeException {

    public InvalidRegisterException(String message) {
        super("Error(s): " + message);
    }
}
