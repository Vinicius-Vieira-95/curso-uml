package com.curso.vnc.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.curso.vnc.domain.Categoria;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Campo nome não pode ser nulo")
	private String nome;
	
	private List<ProdutoDto> produtos = new ArrayList<>();
	
	public CategoriaDto() {
	}

	public CategoriaDto(Categoria entity) {
		this.nome = entity.getNome();
		this.produtos = entity.getProdutos().stream().map(x -> new ProdutoDto(x)).toList();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutoDto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDto> produtos) {
		this.produtos = produtos;
	}
}
