package com.hcdev.sgesc.api.exception;

import lombok.Getter;

public class ErroMensagens {

	@Getter
	private String mensagemUsuario;
	@Getter
	private String mensagemDesenvolvedor;
	
	public ErroMensagens(String mensagemUsuario, String mensagemDesenvolvedor) {
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
}
