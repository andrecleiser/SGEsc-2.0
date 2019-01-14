package com.hcdev.sgesc.api.evento;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class RecursoCriadoEvento extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Long idEntidade;
	
	@Getter
	private HttpServletResponse response;
	
	public RecursoCriadoEvento(Object source, HttpServletResponse response, Long id) {
		super(source);
		
		this.idEntidade = id;
		this.response = response;
		
	}

}
