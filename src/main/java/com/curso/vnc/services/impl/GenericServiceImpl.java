package com.curso.vnc.services.impl;

import java.lang.reflect.Constructor;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.services.interfaces.GenericService;

public class GenericServiceImpl<T, R extends JpaRepository<T, Integer>, DTO> implements GenericService<T, DTO> {
	
	protected DTO typeDto;
	protected final R repository;

	public GenericServiceImpl(R repository, DTO typeDto) {
		this.repository = repository;
		this.typeDto = typeDto;
	}

	@Override
	public T inserir(T entity) {
		repository.save(entity);
		return null;
	}

	@Override
	public DTO buscarPorId(Integer id) {
		var obj = repository.findById(id);
		BeanUtils.copyProperties(obj.get(), typeDto);
		return typeDto;
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
	
    private DTO convertToDto(T entity) {
        BeanUtils.copyProperties(entity, typeDto);
        return typeDto;
    }

}
