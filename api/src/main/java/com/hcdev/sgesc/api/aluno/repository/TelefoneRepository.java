package com.hcdev.sgesc.api.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcdev.sgesc.api.aluno.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
