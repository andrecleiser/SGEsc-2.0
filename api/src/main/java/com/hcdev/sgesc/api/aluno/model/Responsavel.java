package com.hcdev.sgesc.api.aluno.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="responsavel")
@Data
public class Responsavel {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @NotNull
	  @Size(min = 10, max = 70)
	  private String nome;
	  
	  @NotNull
	  @Size(min = 10, max = 40)	  
	  private String email;
	  
	  @NotNull
	  @Size(min = 11, max = 11)	  
	  private String cpf;
	  
	  @Size(max = 11)
	  private String rg;
	  
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name="fk_telefone_id")
	  private Telefone telefone;
	  
}
