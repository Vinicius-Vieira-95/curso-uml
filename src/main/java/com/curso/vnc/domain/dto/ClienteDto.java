package com.curso.vnc.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.enums.TipoCliente;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	private String cpfOuCnpj;

	private String tipo;

	private List<EnderecoDto> enderecos = new ArrayList<>();

	private Set<String> telefones = new HashSet<>();

	public ClienteDto() {
	}
	
	public ClienteDto(String nome, String email, String cpfOuCnpj, String tipo, List<EnderecoDto> enderecos, Set<String> telefones) {
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		this.enderecos = enderecos;
		this.telefones = telefones;
	}

	public ClienteDto(Cliente entity) {
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpfOuCnpj = entity.getCpfOuCnpj();
		this.tipo = entity.getTipo().getDescricao();
		this.enderecos = entity.getEnderecos().stream().map(x -> new EnderecoDto(x)).toList();
		this.telefones = entity.getTelefones();
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

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

}
