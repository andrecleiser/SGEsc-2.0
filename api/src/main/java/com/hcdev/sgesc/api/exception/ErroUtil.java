package com.hcdev.sgesc.api.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;

public class ErroUtil {

	public static List<ErroMensagens> listarErros(String mensagemUsuario, String mensagemDesenvolvedor) {
		return Arrays.asList(new ErroMensagens(mensagemUsuario, mensagemDesenvolvedor));
	}
	
	public static List<ErroMensagens> listarErros(BindingResult bindingResult, MessageSource messageSource) {
		List<ErroMensagens> listaErros = new ArrayList<>();
				
		
		bindingResult.getAllErrors().forEach(fieldErro -> {
			String mensagemDesenvolvedor = fieldErro.toString();
			String mensagemUsuario = messageSource.getMessage(fieldErro, LocaleContextHolder.getLocale());
			
			listaErros.add(new ErroMensagens(mensagemUsuario, mensagemDesenvolvedor));
		});
		
		return listaErros;
	}

}
