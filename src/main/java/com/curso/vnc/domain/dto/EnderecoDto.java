package com.curso.vnc.domain.dto;

import java.io.Serializable;

import com.curso.vnc.domain.Endereco;

public class EnderecoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String cep;

	public EnderecoDto() {
	}

	public EnderecoDto(Endereco entity) {
		this.logradouro = entity.getLogradouro();
		this.numero = entity.getNumero();
		this.complemento = entity.getComplemento();
		this.bairro = entity.getBairro();
		this.cep = entity.getCep();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
