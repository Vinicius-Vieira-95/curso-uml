package com.curso.vnc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoUmlApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository  repo;
	
	public static void main(String[] args){
		SpringApplication.run(CursoUmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria(1, "Informatica"));
		categorias.add(new Categoria(2, "Escritorioa"));
		
		repo.saveAll(categorias);
	}
}
