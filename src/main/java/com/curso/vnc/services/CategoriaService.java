package com.curso.vnc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	
	public Categoria buscar(Integer id) {
		var categoria = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return categoria;
	}
	
}
