package br.upe.acs.utils;

public class InvalidRegisterException extends RuntimeException {

    public InvalidRegisterException(String message) {
        super("Error(s): " + message);
    }
}
