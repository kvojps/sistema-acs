package br.upe.acs.utils.exceptions;

public class InvalidFileFormatException extends IllegalArgumentException {
    public InvalidFileFormatException(String message) {
        super("Error(s): " + message);
    }
}
