package com.hcdev.sgesc.api.exception.aluno;

import com.hcdev.sgesc.api.base.EntidadeException;

public class AlunoException extends EntidadeException {

	private static final long serialVersionUID = 1635275542400254832L;
	
	protected static final String NOME_ENTIDADE = "Aluno(a)";

	public AlunoException(String msg) {
		super(NOME_ENTIDADE, msg);
	}
}
