package com.curso.vnc.controlllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> teste() {
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria(1, "Informatica"));
		categorias.add(new Categoria(2, "Escritorioa"));
		return categorias;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		var cat = service.buscar(id);
		return ResponseEntity.ok().body(cat);
	}
}
