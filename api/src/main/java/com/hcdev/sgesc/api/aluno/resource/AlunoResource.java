package com.hcdev.sgesc.api.aluno.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcdev.sgesc.api.aluno.model.Aluno;
import com.hcdev.sgesc.api.aluno.repository.projecao.ResumoAluno;
import com.hcdev.sgesc.api.aluno.service.AlunoService;
import com.hcdev.sgesc.api.evento.RecursoCriadoEvento;
import com.hcdev.sgesc.api.exception.aluno.AlunoNaoEncontradoException;
import com.hcdev.sgesc.api.util.ConstantesAPI;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(ConstantesAPI.URL_BASE)
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@GetMapping
	public List<Aluno> listar() {
		return this.alunoService.listarTodos();
	}	
	
	@GetMapping(params="resumo")
	public Page<ResumoAluno> resumir(Pageable pageable, @RequestParam(required = false) String nome) {
		System.out.println(nome);
		System.out.println(pageable);
		return this.alunoService.resumir(pageable, nome);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id, HttpServletResponse response) {
		Optional<Aluno> aluno = this.alunoService.buscarPorId(id);
		
		HttpStatus status = aluno.isPresent() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND; 
			
		return ResponseEntity.status(status).body(aluno.orElse(null));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@Valid @RequestBody Aluno novoAluno, HttpServletResponse response) {
		Aluno aluno = this.alunoService.incluir(novoAluno);

		eventPublisher.publishEvent(new RecursoCriadoEvento(this, response, aluno.getId()));	
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void editar(@Valid @RequestBody Aluno aluno, @PathVariable Long id) throws AlunoNaoEncontradoException{
		this.alunoService.editar(id, aluno);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable Long id ) throws AlunoNaoEncontradoException {
		this.alunoService.excluir(id);
	}

}
