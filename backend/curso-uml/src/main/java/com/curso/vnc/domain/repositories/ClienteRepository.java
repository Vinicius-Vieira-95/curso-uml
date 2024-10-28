package com.curso.vnc.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.dto.params.ClientePageDto;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = "SELECT new com.curso.vnc.domain.dto.params.ClientePageDto(nome, email, cpfOuCnpj, tipo) FROM Cliente")
	Page<ClientePageDto> paginaCliente(Pageable pageable);

}