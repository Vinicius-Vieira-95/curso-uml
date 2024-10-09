package com.curso.vnc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.Produto;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUmlApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo1;

	@Autowired
	private ProdutoRepository repo2;

	public static void main(String[] args) {
		SpringApplication.run(CursoUmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 3000.0);
		Produto p2 = new Produto(null, "Tablet", 1500.0);
		Produto p3 = new Produto(null, "Mesa", 300.0);
		Produto p4 = new Produto(null, "Caneta", 2.0);
		Produto p5 = new Produto(null, "NoteBook", 2500.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p5));
		cat2.getProdutos().addAll(Arrays.asList(p4, p3, p5));

		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat1);
		p3.getCategorias().add(cat2);
		p4.getCategorias().add(cat2);
		p5.getCategorias().addAll(Arrays.asList(cat1, cat2));

		repo1.saveAll(Arrays.asList(cat1, cat2));
		repo2.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
}
