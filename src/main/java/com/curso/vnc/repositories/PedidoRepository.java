package com.curso.vnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
