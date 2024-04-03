package com.curso.vnc.domain.dto.params;

import java.io.Serializable;

import com.curso.vnc.domain.enums.TipoCliente;

public class ClientePageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	private String cpfOuCnpj;

	private String tipo;

	public ClientePageDto() {
	}

	public ClientePageDto(String nome, String email, String cpfOuCnpj, Integer tipo) {
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo =  TipoCliente.toEnum(tipo).getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getDescricao();
	}

}
