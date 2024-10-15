package com.curso.vnc.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.curso.vnc.domain.Produto;
import com.curso.vnc.domain.dto.ProdutoDto;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.repositories.ProdutoRepository;
import com.curso.vnc.services.impl.GenericServiceImpl;

@Service
public class ProdutoService extends GenericServiceImpl<Produto, ProdutoRepository, ProdutoDto, Integer>{
	
	//private CategoriaRepository categoriaRepository;
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository repository, ModelMapper mapper, CategoriaRepository categoriaRepository) {
		super(repository, mapper, Produto.class, ProdutoDto.class, Integer.class);
		//this.categoriaRepository = categoriaRepository;
	}
	
	public void SalvaProduto(ProdutoDto produto, Integer idCategoria) {
		var prod = this.inserir(produto);
		var prod2 = produtoRepository.getReferenceById(prod.getId());
		System.out.println(prod2.getNome());
	}
	
}
