package br.upe.acs.utils.exceptions;

public class AcsException extends RuntimeException {

	public AcsException(String mensagem) {
		super("Error(s): " + mensagem);
	}
}
