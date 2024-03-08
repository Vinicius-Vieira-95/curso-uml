package com.curso.vnc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.Produto;
import com.curso.vnc.domain.dto.CategoriaDto;
import com.curso.vnc.domain.dto.ProdutoDto;

@Configuration
public class MapperConfig {
	
	@Bean
	ModelMapper mapper() {
		var mapper = new ModelMapper();
		mapper.createTypeMap(Categoria.class, CategoriaDto.class);
		//mapeamento caso alguns nome de atributos das classes não batem
		//.addMapping(Categoria::getProdutos, CategoriaDto::setProdutos);
		
		mapper.createTypeMap(Produto.class, ProdutoDto.class);
		return mapper;
	}
}
