package br.upe.acs.utils;

public class AcsException extends RuntimeException {

	public AcsException(String mensagem) {
		super("Error(s): " + mensagem);
	}
}
