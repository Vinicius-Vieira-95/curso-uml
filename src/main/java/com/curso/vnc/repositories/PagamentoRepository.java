package com.curso.vnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
