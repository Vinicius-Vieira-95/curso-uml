package com.curso.vnc.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;
import com.curso.vnc.services.interfaces.GenericService;

public class GenericServiceImpl<T, R extends JpaRepository<T, O>, DTO, O> implements GenericService<T, DTO, O> {

	protected final ModelMapper mapper;
	protected final R repository;
	
	protected final Class<T> entityClass;
	protected final Class<DTO> dtoClass;
	protected final Class<O> objClass;

	public GenericServiceImpl(R repository, ModelMapper mapper, Class<T> entityClass, Class<DTO> dtoClass, Class<O> objClass) {
		this.mapper = mapper;
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
		this.objClass = objClass;
	}

	@Override
	public DTO inserir(DTO objDto) {
		var entity = mapper.map(objDto, entityClass);
		repository.save(entity);
		return objDto;
	}

	@Override
	public void delete(O id) {
		repository.deleteById(id);
	}

	@Override
	public List<T> listar() {
		var objs = repository.findAll();
		return objs;
	}

	@Override
	public DTO buscarPorId(O id) {
		var obj = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Classe não encontrada, objeto retornando nulo"));
		return mapper.map(obj, dtoClass);
	}
	
	public Page<DTO> listarPaginado(Pageable pageable) {
        Page<T> entityPage = repository.findAll(pageable);
        return entityPage.map(entity -> mapper.map(entity, dtoClass));
    }

}
