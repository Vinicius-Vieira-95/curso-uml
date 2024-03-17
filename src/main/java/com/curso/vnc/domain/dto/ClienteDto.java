package com.curso.vnc.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.curso.vnc.domain.Cliente;

import jakarta.validation.constraints.NotBlank;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "campo nome não pode ser nulo")
	private String nome;

	private String email;
	
	@NotBlank(message = "campo cpf/cnpj não pode ser nulo")
	private String cpfOuCnpj;
	
	@NotBlank(message = "campo tipo não pode ser nulo")
	private String tipo;

	private List<EnderecoDto> enderecos = new ArrayList<>();

	private Set<String> telefones = new HashSet<>();

	public ClienteDto() {
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

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
