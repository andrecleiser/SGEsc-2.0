package com.hcdev.sgesc.api.aluno.repository.consultas;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.hcdev.sgesc.api.aluno.repository.projecao.ResumoAluno;

public class AlunoRepositoryImpl implements AlunoRepositoryQuery {
	
	private static final String QUERY_RESUMO_ALUNO =
			"select new com.hcdev.sgesc.api.aluno.repository.projecao." +
			"	ResumoAluno(a.id, a.nome, a.dataNascimento, r.nome, t.celular, a.diaVencimento) " +
			"from Aluno a join a.responsavel r left join r.telefone t " +
			"where upper(a.nome) like :nomeParcial order by a.nome";

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<ResumoAluno> resumir(Pageable pageable, String nome) {
		StringBuilder consulta = new StringBuilder(AlunoRepositoryImpl.QUERY_RESUMO_ALUNO);
		
		TypedQuery<ResumoAluno> query = manager.createQuery(consulta.toString(), ResumoAluno.class);
		
		Optional<String> nomeOptional = Optional.ofNullable(nome);
		String nomeParcial = nomeOptional.isPresent() ? "%".concat(nomeOptional.get()).concat("%") : "%";
		query.setParameter("nomeParcial", nomeParcial.toUpperCase());
		int total = query.getResultList().size();
		
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		
		List<ResumoAluno> resumo = query.getResultList();
		
		if (resumo.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		
    	return new PageImpl<ResumoAluno>(resumo, pageable, total);
	}
}
