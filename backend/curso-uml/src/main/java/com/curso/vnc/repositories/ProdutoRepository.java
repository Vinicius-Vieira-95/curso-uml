package com.curso.vnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
