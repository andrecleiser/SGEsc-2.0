package com.hcdev.sgesc.api.exception;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcdev.sgesc.api.exception.aluno.AlunoNaoEncontradoException;

@ControllerAdvice
public class GeralException extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagemUsuario = this.messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = this.getCausaErro(ex);
		
		return handleExceptionInternal(ex,
				ErroUtil.listarErros(mensagemUsuario, mensagemDesenvolvedor),
				headers,
				HttpStatus.BAD_REQUEST,
				request);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return handleExceptionInternal(ex,
				ErroUtil.listarErros(ex.getBindingResult(), this.messageSource),
				headers,
				HttpStatus.BAD_REQUEST,
				request);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
		
		String mensagemUsuario = this.messageSource.getMessage("mensagem.dataset-vazio", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = this.getCausaErro(ex);
		
		return handleExceptionInternal(ex, ErroUtil.listarErros(mensagemUsuario, mensagemDesenvolvedor),
				new HttpHeaders(),
				HttpStatus.BAD_REQUEST,
				request);
	}
	
	@ExceptionHandler(AlunoNaoEncontradoException.class)
	public ResponseEntity<Object> handleAlunoNaoEncontradoException(AlunoNaoEncontradoException ex, WebRequest request) {
		
		String mensagemUsuario = ex.getMessage();
		String mensagemDesenvolvedor = this.messageSource.getMessage("mensagem.falha-negocio", null, LocaleContextHolder.getLocale());
		
		return handleExceptionInternal(ex,
				ErroUtil.listarErros(mensagemUsuario, mensagemDesenvolvedor),
				new HttpHeaders(),
				HttpStatus.BAD_REQUEST,
				request);
	};

	private String getCausaErro(Exception ex) {
		Optional<Throwable> causa = Optional.ofNullable(ex.getCause());
		return causa.isPresent() ? causa.get().getCause().toString() : ex.toString();
	}
}
