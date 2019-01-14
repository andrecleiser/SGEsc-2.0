package com.hcdev.sgesc.api.exception.aluno;

import com.hcdev.sgesc.api.base.EntidadeException;

public class AlunoNaoEncontradoException extends AlunoException {

	private static final long serialVersionUID = -6503066594407776478L;
	
	public AlunoNaoEncontradoException() {
		super(EntidadeException.NAO_ENCONTRADA);
	}
}
