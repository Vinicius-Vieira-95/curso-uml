package com.curso.vnc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.vnc.domain.dto.ClienteDto;
import com.curso.vnc.domain.dto.EnderecoDto;
import com.curso.vnc.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<ClienteDto> inserir(@RequestBody @Valid ClienteDto cliente) {
		var clienteSalvo = service.inserir(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}

	@GetMapping
	public ResponseEntity<Page<ClienteDto>> paginaDeClientes(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		var clientes = service.listarPaginado(pageable);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		var cliente = service.buscarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDto> atualizarDados(@RequestBody ClienteDto cliente, @PathVariable("id") Integer id) {
		service.atualizar(cliente, id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}/endereco")
	public ResponseEntity<ClienteDto> salvarEndereco(@RequestBody EnderecoDto enderecoDto, @PathVariable("id")Integer idCliente) {
		var cliente = service.salvarEndereco(enderecoDto, idCliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
