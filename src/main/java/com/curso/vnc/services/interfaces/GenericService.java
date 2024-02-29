package com.curso.vnc.services.interfaces;

import java.util.List;

public interface GenericService<T, DTO> {
	
	List<T>listar();
	T inserir(T entity);
	void delete(Integer id);
	DTO buscarPorId(Integer id);
}
