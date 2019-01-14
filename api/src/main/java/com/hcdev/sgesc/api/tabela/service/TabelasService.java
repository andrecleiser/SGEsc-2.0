package com.hcdev.sgesc.api.tabela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcdev.sgesc.api.tabela.model.DoencaPreExistente;
import com.hcdev.sgesc.api.tabela.model.MotivoMatricula;
import com.hcdev.sgesc.api.tabela.repository.DoencaPreExistenteRepository;
import com.hcdev.sgesc.api.tabela.repository.MotivoMatriculaRepository;

@Service
public class TabelasService {

	@Autowired
	private MotivoMatriculaRepository motivoMatriculaRepository;
	
	@Autowired
	private DoencaPreExistenteRepository doencaPreExistenteRepository;
	
	/**
	 * Métodos usados nas operações com a tabela MotivoMatricula
	 * @return
	 */
	
	public List<MotivoMatricula> listarMotivosMatricula() {
	  	return this.motivoMatriculaRepository.findAll();
	}
	
	public MotivoMatricula incluirMotivoMatricula(MotivoMatricula motivoMatricula) {
	
		return this.motivoMatriculaRepository.save(motivoMatricula);
	
	}
	
	/**
	 * Métodos usados nas operações com a tabela DoencaPreExistente
	 * @return
	 */
	
	public List<DoencaPreExistente> listarDoencaPreExistente() {
	  	return this.doencaPreExistenteRepository.findAll();
	}
	
	public DoencaPreExistente incluirDoencaPreExistente(DoencaPreExistente doencaPreExistente) {
	
		return this.doencaPreExistenteRepository.save(doencaPreExistente);
	
	}
	
}
