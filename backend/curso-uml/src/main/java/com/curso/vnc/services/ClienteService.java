package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.dto.ClienteDto;
import com.curso.vnc.repositories.ClienteRepository;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class ClienteService extends GenericServiceImpl<Cliente, ClienteRepository, ClienteDto, Integer>{

	public ClienteService(ClienteRepository repository, ModelMapper mapper) {
		super(repository, mapper, Cliente.class, ClienteDto.class, Integer.class);
	}
	
}
