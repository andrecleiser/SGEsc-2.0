package com.hcdev.sgesc.api.aluno.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hcdev.sgesc.api.aluno.enums.DoencaPreExistenteEnum;
import com.hcdev.sgesc.api.aluno.enums.MotivoMatriculaEnum;

import lombok.Data;

@Entity
@Data
@Table(name = "aluno")
public class Aluno {
      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Size(min = 10, max = 70)
	  @Column(length = 70)
	  @NotNull
	  private String nome;
	  
	  @Column(name = "data_nascimento")
	  @NotNull
	  private LocalDate dataNascimento;
	  
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "fk_endereco_id")
	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	  private Endereco endereco;
	  
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "fk_telefone_id")
	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	  private Telefone telefone;
	  
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "fk_responsavel_id")
	  @NotNull
	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	  private Responsavel responsavel;

	  @Size(min = 10, max = 70)
	  @Column(name = "nome_pai")
	  private String nomePai;
	  
	  @Size(min = 10, max = 70)
	  @Column(name = "nome_mae")
	  private String nomeMae;
	  
	  @Column(name = "data_cadastramento")
	  private LocalDate dataCadastramento;
	  
	  @Column(name = "data_inativacao")
	  private LocalDate dataInativacao;
	  
	  @Size(max = 200)
	  private String observacao;
	  
	  @Column(name = "cd_motivo_matricula")
	  @Enumerated(EnumType.ORDINAL)
	  private MotivoMatriculaEnum motivoMatricula;
	  
	  @Column(name = "cd_doenca_pre_existente")
	  @Enumerated(EnumType.ORDINAL)
	  private DoencaPreExistenteEnum doencaPreExistente;
	  
	  @Range(min = 1, max = 31)
	  @Column(name = "dia_vencimento")
	  private Long diaVencimento;
	  
}
