package com.curso.vnc.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, DTO, ID> {
	
	DTO inserir(DTO dto);
	void delete(ID id);
	DTO buscarPorId(ID id);
	void atualizar(DTO dto, ID id);
	Page<DTO> listarPaginado(Pageable pageable);
}
