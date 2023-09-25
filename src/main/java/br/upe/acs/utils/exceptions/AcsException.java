package br.upe.acs.utils.exceptions;

public class AcsException extends RuntimeException {

	public AcsException(String message) {
		super("Error(s): " + message);
	}
}
