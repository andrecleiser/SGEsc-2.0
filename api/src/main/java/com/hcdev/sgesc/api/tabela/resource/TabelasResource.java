package com.hcdev.sgesc.api.tabela.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcdev.sgesc.api.evento.RecursoCriadoEvento;
import com.hcdev.sgesc.api.tabela.model.DoencaPreExistente;
import com.hcdev.sgesc.api.tabela.model.MotivoMatricula;
import com.hcdev.sgesc.api.tabela.service.TabelasService;
import com.hcdev.sgesc.api.util.ConstantesAPI;

@RestController
@CrossOrigin(ConstantesAPI.URL_BASE)
@RequestMapping("/tabelas")
public class TabelasResource {
	
	private static final String URL_MOTIVOS_MATRICULA = "/motivo-matricula";
	private static final String URL_DOENCA_PRE_EXIXTENTE = "/doenca-pre-existente";
	
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private TabelasService tabelasService;
	
	@GetMapping(TabelasResource.URL_MOTIVOS_MATRICULA)
	public List<MotivoMatricula> listaMotivoMatricula() {
		return this.tabelasService.listarMotivosMatricula();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(TabelasResource.URL_MOTIVOS_MATRICULA)
	public void incluirMotivoMatricula(@Valid @RequestBody MotivoMatricula novoMotivoMatricula, HttpServletResponse response) {
		MotivoMatricula novo = this.tabelasService.incluirMotivoMatricula(novoMotivoMatricula);
		
		this.eventPublisher.publishEvent(new RecursoCriadoEvento(this, response, novo.getId()));
	}

	@GetMapping(TabelasResource.URL_DOENCA_PRE_EXIXTENTE)
	public List<DoencaPreExistente> listaDoencaPreExistente() {
		return this.tabelasService.listarDoencaPreExistente();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(TabelasResource.URL_DOENCA_PRE_EXIXTENTE)
	public void incluirDoencaPreExistente(@Valid @RequestBody DoencaPreExistente novoDoencaPreExistente, HttpServletResponse response) {
		DoencaPreExistente novo = this.tabelasService.incluirDoencaPreExistente(novoDoencaPreExistente);
		
		this.eventPublisher.publishEvent(new RecursoCriadoEvento(this, response, novo.getId()));
	}
}
