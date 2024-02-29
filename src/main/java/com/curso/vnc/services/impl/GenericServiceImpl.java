package com.curso.vnc.services.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.services.interfaces.GenericService;

public class GenericServiceImpl<T, R extends JpaRepository<T, Integer>> implements GenericService<T> {

	protected final R repository;

	public GenericServiceImpl(R repository) {
		this.repository = repository;
	}

	@Override
	public T inserir(T entity) {
		repository.save(entity);
		return null;
	}

	@Override
	public T buscarPorId(Integer id) {
		var obj =repository.getReferenceById(id);
		return obj;
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<T> listar() {
		var objs = repository.findAll();
		return objs;
	}
	
	
}
