package com.curso.vnc.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;
import com.curso.vnc.services.interfaces.GenericService;

public class GenericServiceImpl<T, R extends JpaRepository<T, Integer>, DTO> implements GenericService<T, DTO> {

	protected final ModelMapper mapper;
	protected final R repository;
	
	protected final Class<T> entityClass;
	protected final Class<DTO> dtoClass;

	public GenericServiceImpl(R repository, ModelMapper mapper, Class<T> entityClass, Class<DTO> dtoClass) {
		this.mapper = mapper;
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}

	@Override
	public DTO inserir(DTO objDto) {
		var entity = mapper.map(objDto, entityClass);
		repository.save(entity);
		return objDto;
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

	@Override
	public DTO buscarPorId(Integer id) {
		var obj = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Classe não encontrada, objeto retornando nulo"));
		return mapper.map(obj, dtoClass);
	}

}
