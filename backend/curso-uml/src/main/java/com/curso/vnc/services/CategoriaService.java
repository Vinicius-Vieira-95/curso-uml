package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.dto.CategoriaDto;
import com.curso.vnc.domain.repositories.CategoriaRepository;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class CategoriaService extends GenericServiceImpl<Categoria, CategoriaRepository, CategoriaDto, Integer>{

	public CategoriaService(CategoriaRepository repository, ModelMapper mapper) {
		super(repository, mapper, Categoria.class, CategoriaDto.class, Integer.class);
	}
}
