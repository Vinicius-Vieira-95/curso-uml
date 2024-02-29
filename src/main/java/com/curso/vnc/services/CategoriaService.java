package com.curso.vnc.services;

import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.dto.CategoriaDto;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class CategoriaService extends GenericServiceImpl<Categoria, CategoriaRepository, CategoriaDto>{

	public CategoriaService(CategoriaRepository repository, CategoriaDto categoriaDto) {
		super(repository, categoriaDto);
	}
}
