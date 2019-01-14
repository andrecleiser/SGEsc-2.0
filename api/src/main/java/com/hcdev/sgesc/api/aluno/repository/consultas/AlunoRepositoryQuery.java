package com.hcdev.sgesc.api.aluno.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hcdev.sgesc.api.aluno.repository.projecao.ResumoAluno;

public interface AlunoRepositoryQuery {
	
	public Page<ResumoAluno> resumir(Pageable pageable, String nome);

}
