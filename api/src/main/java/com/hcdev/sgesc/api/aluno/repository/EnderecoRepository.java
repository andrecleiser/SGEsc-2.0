package com.hcdev.sgesc.api.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcdev.sgesc.api.aluno.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
