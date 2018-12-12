package com.hcdev.sgesc.api.aluno.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcdev.sgesc.api.aluno.model.Aluno;
import com.hcdev.sgesc.api.aluno.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> listarAlunos() {
		return this.alunoService.listarAlunos();
	}

}
