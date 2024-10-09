package com.curso.vnc.domain.dto;

import com.curso.vnc.domain.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDto {
	
	@NotBlank(message  = "campo nome não pode ser nulo")
	private String nome;
	
	@NotNull(message = "valor do preço inválido")
	private Double preco;
	
	public ProdutoDto() {
	}

	ProdutoDto(Produto entity){
		this.nome = entity.getNome();
		this.preco = entity.getPreco();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
