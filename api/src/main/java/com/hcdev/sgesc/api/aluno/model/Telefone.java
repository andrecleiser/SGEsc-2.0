package com.hcdev.sgesc.api.aluno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="telefone")
@Data
public class Telefone {

	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	  
	  @Size(min=8, max=11)
	  private String residencial;
	  
	  @Size(min=8, max=11)
	  private String celular;
	  
	  @Size(min=8, max=11)
	  private String trabalho;
	  
	  @Size(max=4)
	  private String ramal_trabalho;


}
