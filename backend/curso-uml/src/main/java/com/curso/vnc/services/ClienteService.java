package com.curso.vnc.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.Endereco;
import com.curso.vnc.domain.dto.ClienteDto;
import com.curso.vnc.domain.dto.EnderecoDto;
import com.curso.vnc.domain.repositories.ClienteRepository;
import com.curso.vnc.domain.repositories.EnderecoRepository;
import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;
import com.curso.vnc.services.impl.GenericServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class ClienteService extends GenericServiceImpl<Cliente, ClienteRepository, ClienteDto, Integer> {
	
	public ClienteService(ClienteRepository repository, ModelMapper mapper) {
		super(repository, mapper, Cliente.class, ClienteDto.class, Integer.class);
	}
	
	@Transactional
	@Override
	public void atualizar(ClienteDto clienteDto, Integer id) {
		var cliente = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		atualizarDados(clienteDto, cliente);
		repository.save(cliente);
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
	
	private void atualizarDados(ClienteDto clienteDto, Cliente cliente) {
		cliente.getEnderecos().clear();
		for(EnderecoDto eDto: clienteDto.getEnderecos()) {
			var endereco = mapper.map(eDto, Endereco.class);
			endereco.setClient(cliente);
			cliente.salvarEndereco(endereco);
		}
		
		cliente.setCpfOuCnpj(clienteDto.getCpfOuCnpj());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setNome(clienteDto.getNome());
		cliente.setTelefones(clienteDto.getTelefones());
		cliente.setTipo(clienteDto.getTipo());
	}

}
