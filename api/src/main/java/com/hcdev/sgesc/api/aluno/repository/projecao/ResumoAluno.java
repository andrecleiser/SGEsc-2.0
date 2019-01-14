package com.hcdev.sgesc.api.aluno.repository.projecao;

import java.time.LocalDate;

import lombok.Getter;

public class ResumoAluno {
	@Getter
    private Long id;
    
    @Getter
	private String nome;
    
    @Getter
	private LocalDate dataNascimento;
    
    @Getter
    private String responsavelNome;
    
    @Getter
    private String responsavelCelular;
    
    @Getter
    private Long diaVencimento;
    
	public ResumoAluno(Long id, String nome, LocalDate dataNascimento, String responsavelNome,
			String responsavelCelular, Long diaVencimento) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.responsavelNome = responsavelNome;
		this.responsavelCelular = responsavelCelular;
		this.diaVencimento = diaVencimento;
	}
}
