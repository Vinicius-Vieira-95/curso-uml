package com.curso.vnc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.vnc.domain.*;
import com.curso.vnc.domain.dto.*;

@Configuration
public class MapperConfig {
	
	@Bean
	ModelMapper mapper() {
		var mapper = new ModelMapper();
		mapper.createTypeMap(Categoria.class, CategoriaDto.class);
		mapper.createTypeMap(CategoriaDto.class, Categoria.class);
		//mapeamento caso alguns nome de atributos das classes não batem
		//.addMapping(Categoria::getProdutos, CategoriaDto::setProdutos);
		
		mapper.createTypeMap(Produto.class, ProdutoDto.class);
		mapper.createTypeMap(ProdutoDto.class, Produto.class);
		mapper.createTypeMap(Cliente.class, ClienteDto.class)
		.addMapping(Cliente::getTipo, ClienteDto::setTipo);
		
		mapper.createTypeMap(ClienteDto.class, Cliente.class);
		mapper.createTypeMap(Endereco.class, EnderecoDto.class);
		mapper.createTypeMap(EnderecoDto.class, Endereco.class);
		return mapper;
	}
}
