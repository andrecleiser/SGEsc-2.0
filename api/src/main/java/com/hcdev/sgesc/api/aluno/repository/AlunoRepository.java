package com.hcdev.sgesc.api.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcdev.sgesc.api.aluno.model.Aluno;
import com.hcdev.sgesc.api.aluno.repository.consultas.AlunoRepositoryQuery;

public interface AlunoRepository extends JpaRepository<Aluno, Long>, AlunoRepositoryQuery {
	
	

}
