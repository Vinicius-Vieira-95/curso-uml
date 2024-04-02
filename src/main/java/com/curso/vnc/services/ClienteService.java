package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.dto.ClienteDto;
import com.curso.vnc.domain.dto.params.ClientePageDto;
import com.curso.vnc.repositories.ClienteRepository;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class ClienteService extends GenericServiceImpl<Cliente, ClienteRepository, ClienteDto>{

	public ClienteService(ClienteRepository repository, ModelMapper mapper) {
		super(repository, mapper, Cliente.class, ClienteDto.class);
	}
	
	public Page<ClientePageDto> pagina(Pageable pageable) {
		var page = repository.paginaCliente(pageable);
		return page;
	}
}
