package com.curso.vnc.domain.dto;

import com.curso.vnc.domain.Produto;

public class ProdutoDto {

	private String nome;
	private Double preco;
	
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
