package com.curso.vnc.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.dto.CategoriaDto;
import com.curso.vnc.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public List<Categoria> teste() {
		var categorias = service.listar();
		return categorias;
	}
	
//	@PostMapping
//	public ResponseEntity<CategoriaDto> inseri(@RequestBody @Valid CategoriaDto categoriaDto){
//		var categoriaSalva = service.inserir(categoriaDto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
//	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		var cat = service.buscarPorId(id);
		return ResponseEntity.ok().body(cat);
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDto> inserir(@RequestBody CategoriaDto catDto) {
		var categoria = service.inserir(catDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
