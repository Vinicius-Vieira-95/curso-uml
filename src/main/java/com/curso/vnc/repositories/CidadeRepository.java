package com.curso.vnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
