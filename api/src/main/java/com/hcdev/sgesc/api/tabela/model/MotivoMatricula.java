package com.hcdev.sgesc.api.tabela.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="motivo_matricula")
@Data
public class MotivoMatricula {
	
	@Id
	private Long id;
	
	@NotNull
	@Size(min=10, max=50)
	private String descricao;
}
