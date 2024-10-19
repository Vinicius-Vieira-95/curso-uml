package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Produto;
import com.curso.vnc.domain.dto.ProdutoDto;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.repositories.ProdutoRepository;
import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class ProdutoService extends GenericServiceImpl<Produto, ProdutoRepository, ProdutoDto, Integer>{
	
	private CategoriaRepository categoriaRepository;
	
	public ProdutoService(ProdutoRepository repository, ModelMapper mapper, CategoriaRepository categoriaRepository) {
		super(repository, mapper, Produto.class, ProdutoDto.class, Integer.class);
		this.categoriaRepository = categoriaRepository;
	}
	
	public ProdutoDto salvaProduto(ProdutoDto produto, Integer idCategoria) {
		var cat = categoriaRepository.findById(idCategoria).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada"));
		var aux = this.inserir(produto);
		var prod = repository.getReferenceById(aux.getId());
		prod.getCategorias().add(cat);
		repository.save(prod);
		return new ProdutoDto(prod);
	}
	
}
