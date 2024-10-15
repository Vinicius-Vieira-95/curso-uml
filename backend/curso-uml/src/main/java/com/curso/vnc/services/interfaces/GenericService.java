package com.curso.vnc.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, DTO, ID> {
	
	List<T>listar();
	DTO inserir(DTO entity);
	void delete(ID id);
	DTO buscarPorId(ID id);
	Page<DTO> listarPaginado(Pageable pageable);
}
