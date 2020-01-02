package com.brodrigues.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodrigues.cadastro.model.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa, Long> {

}
