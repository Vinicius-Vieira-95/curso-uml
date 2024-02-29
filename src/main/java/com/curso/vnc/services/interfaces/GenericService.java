package com.curso.vnc.services.interfaces;

import java.util.List;

public interface GenericService<T> {
	
	List<T>listar();
	T inserir(T entity);
	T buscarPorId(Integer id);
	void delete(Integer id);
}
