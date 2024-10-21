package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.Endereco;
import com.curso.vnc.domain.dto.ClienteDto;
import com.curso.vnc.domain.dto.EnderecoDto;
import com.curso.vnc.repositories.ClienteRepository;
import com.curso.vnc.repositories.EnderecoRepository;
import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class ClienteService extends GenericServiceImpl<Cliente, ClienteRepository, ClienteDto, Integer> {

	private EnderecoRepository enderecoRepository;

	public ClienteService(ClienteRepository repository, ModelMapper mapper, EnderecoRepository enderecoRepository) {
		super(repository, mapper, Cliente.class, ClienteDto.class, Integer.class);
		this.enderecoRepository = enderecoRepository;
	}

	public ClienteDto salvarEndereco(EnderecoDto enderecoDto, Integer idCliente) {
		var cliente = repository.findById(idCliente)
				.orElseThrow(() -> new ObjectNotFoundException("cliente não encontrado"));

		var endereco = mapper.map(enderecoDto, Endereco.class);
		endereco.setClient(cliente);
		cliente.salvarEndereco(endereco);
		var teste = repository.save(cliente);
		return mapper.map(teste, ClienteDto.class);
	}

}
