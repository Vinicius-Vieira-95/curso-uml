package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Produto;
import com.curso.vnc.domain.dto.ProdutoDto;
import com.curso.vnc.repositories.ProdutoRepository;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class ProdutoService extends GenericServiceImpl<Produto, ProdutoRepository, ProdutoDto, Integer>{
	
	public ProdutoService(ProdutoRepository repository, ModelMapper mapper) {
		super(repository, mapper, Produto.class, ProdutoDto.class, Integer.class);
	}
	
}
