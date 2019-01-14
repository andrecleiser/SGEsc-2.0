package com.hcdev.sgesc.api.base;

public class EntidadeException extends Exception {

	private static final long serialVersionUID = -6611920300284995143L;
	
	protected static final String NAO_ENCONTRADA = "não encontrado(a)";
	
	public EntidadeException(String nome, String msg) {
		super(nome.concat(" ").concat(msg));
	}
}
