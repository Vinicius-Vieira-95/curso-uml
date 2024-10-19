package com.curso.vnc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.vnc.domain.dto.CategoriaDto;
import com.curso.vnc.domain.dto.ProdutoDto;
import com.curso.vnc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<Page<ProdutoDto>> paginaProdutos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		var lista = service.listarPaginado(pageable);
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping(value = "/{categoriaId}")
	public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody ProdutoDto produto, @PathVariable("categoriaId") Integer categoriaId) {
		var salvo = service.salvaProduto(produto, categoriaId);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
}
