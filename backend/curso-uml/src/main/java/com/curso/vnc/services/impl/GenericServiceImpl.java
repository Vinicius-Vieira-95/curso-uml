package com.curso.vnc.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;
import com.curso.vnc.services.interfaces.GenericService;

public class GenericServiceImpl<T, R extends JpaRepository<T, ID>, DTO, ID> implements GenericService<T, DTO, ID> {

	protected final ModelMapper mapper;
	protected final R repository;
	
	protected final Class<T> entityClass;
	protected final Class<DTO> dtoClass;
	protected final Class<ID> objIdClass;

	public GenericServiceImpl(R repository, ModelMapper mapper, Class<T> entityClass, Class<DTO> dtoClass, Class<ID> objIdClass) {
		this.mapper = mapper;
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
		this.objIdClass = objIdClass;
	}

	@Override
	public DTO inserir(DTO objDto) {
		var entity = mapper.map(objDto, entityClass);
		entity = repository.save(entity);
		objDto = mapper.map(entity, dtoClass);
		return objDto;
	}

	@Override
	public void delete(ID id) {
		repository.deleteById(id);
	}

	@Override
	public List<T> listar() {
		var objs = repository.findAll();
		return objs;
	}

	@Override
	public DTO buscarPorId(ID id) {
		var obj = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
		return mapper.map(obj, dtoClass);
	}
	
	@Override
	public Page<DTO> listarPaginado(Pageable pageable) {
        Page<T> entityPage = repository.findAll(pageable);
        return entityPage.map(entity -> mapper.map(entity, dtoClass));
    }

}
