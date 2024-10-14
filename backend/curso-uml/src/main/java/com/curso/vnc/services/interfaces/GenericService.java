package com.curso.vnc.services.interfaces;

import java.util.List;

public interface GenericService<T, DTO, O> {
	
	List<T>listar();
	DTO inserir(DTO entity);
	void delete(O id);
	DTO buscarPorId(O id);
}
