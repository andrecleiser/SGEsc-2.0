package com.hcdev.sgesc.api.aluno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcdev.sgesc.api.aluno.model.Aluno;
import com.hcdev.sgesc.api.aluno.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listarAlunos() {
		return this.alunoRepository.findAll();
	}

}
