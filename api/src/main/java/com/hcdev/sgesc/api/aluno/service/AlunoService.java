package com.hcdev.sgesc.api.aluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcdev.sgesc.api.aluno.model.Aluno;
import com.hcdev.sgesc.api.aluno.model.Endereco;
import com.hcdev.sgesc.api.aluno.model.Responsavel;
import com.hcdev.sgesc.api.aluno.model.Telefone;
import com.hcdev.sgesc.api.aluno.repository.AlunoRepository;
import com.hcdev.sgesc.api.aluno.repository.EnderecoRepository;
import com.hcdev.sgesc.api.aluno.repository.ResponsavelRepository;
import com.hcdev.sgesc.api.aluno.repository.TelefoneRepository;
import com.hcdev.sgesc.api.aluno.repository.projecao.ResumoAluno;
import com.hcdev.sgesc.api.base.BaseService;
import com.hcdev.sgesc.api.exception.aluno.AlunoNaoEncontradoException;

@Service
public class AlunoService extends BaseService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	@Autowired
	private TelefoneRepository telefoneRepository;	
	
	@Autowired
	private ResponsavelRepository ResponsavelRepository;
	
	
	public Page<Aluno> listar(Pageable pageable) {
		return this.alunoRepository.findAll(pageable);
	}

	public Page<ResumoAluno> resumir(Pageable pageable, String nome) {
		return this.alunoRepository.resumir(pageable, nome);
	}
	
	@Transactional
	public Aluno incluir(Aluno novoAluno) {
		
    	Optional<Endereco> enderecoOptional = Optional.ofNullable(novoAluno.getEndereco());
    	
    	if (enderecoOptional.isPresent()) {
    		novoAluno.setEndereco(this.enderecoRepository.save(novoAluno.getEndereco()));
    	}
    	
    	Optional<Telefone> telefoneOptional = Optional.ofNullable(novoAluno.getTelefone());
    	
    	if (telefoneOptional.isPresent()) {
    		novoAluno.setTelefone(this.telefoneRepository.save(novoAluno.getTelefone()));
    	}
    	
    	Optional<Responsavel> responsavelOptional = Optional.ofNullable(novoAluno.getResponsavel());
    	
    	if (responsavelOptional.isPresent()) {
    		novoAluno.setResponsavel(this.ResponsavelRepository.save(novoAluno.getResponsavel()));
    	}
  	
    	return this.alunoRepository.save(novoAluno);
	}
	
	public Optional<Aluno> buscarPorId(Long id) {
		return this.alunoRepository.findById(id);
	}

	public void editar(Long id, Aluno aluno) throws AlunoNaoEncontradoException {
		
		Optional<Aluno> alunoOptional = this.alunoRepository.findById(id); 
		
		if (!alunoOptional.isPresent()) {
			throw new AlunoNaoEncontradoException(); 
		}
	}

	public List<Aluno> listarTodos() {
		return this.alunoRepository.findAll();
	}
	
	public void excluir(Long id) throws AlunoNaoEncontradoException{
		Optional<Aluno> aluno = this.alunoRepository.findById(id);
		
		if (!aluno.isPresent()) {
			throw new AlunoNaoEncontradoException();
		}
		
		this.alunoRepository.delete(aluno.get());
	}
}
