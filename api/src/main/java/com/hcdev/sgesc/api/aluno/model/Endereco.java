package com.hcdev.sgesc.api.aluno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 60)
	private String rua;
	
	@Size(max = 20)
	private String complemento;
	
	@Size(min = 5, max = 30)
	private String bairro;
	
	@Size(min = 5, max = 50)
	private String cidade;
	
	@Size(min = 2, max = 2)
	private String estado;
	
	@Size(min = 8, max = 8)
	private String cep;
}
