package br.upe.acs.utils.exceptions;

public class ConvertFileException extends RuntimeException {
    public ConvertFileException(String message) {
        super("Error(s): " + message);
    }
}
