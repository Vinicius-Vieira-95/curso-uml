package com.curso.vnc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.Cidade;
import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.Endereco;
import com.curso.vnc.domain.Estado;
import com.curso.vnc.domain.Produto;
import com.curso.vnc.domain.enums.TipoCliente;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.repositories.CidadeRepository;
import com.curso.vnc.repositories.ClienteRepository;
import com.curso.vnc.repositories.EnderecoRepository;
import com.curso.vnc.repositories.EstadoRepository;
import com.curso.vnc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUmlApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo1;

	@Autowired
	private ProdutoRepository repo2;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
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
		
		Estado est1 = new Estado(null, "Ceará");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Fortaleza", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cl1 = new Cliente(null, "Marisa Silva", "mariasilva@gmail.com", "111111111-11", TipoCliente.PESSOAFISICA);
		Cliente cl2 = new Cliente(null, "João Marcos", "joaoa@gmail.com", "222222222-11", TipoCliente.PESSOAFISICA);
		Cliente cl3 = new Cliente(null, "Ana Cecilia Dantas", "ana@gmail.com", "333333333-33", TipoCliente.PESSOAJURIDICA);
		
		cl1.getTelefones().addAll(Arrays.asList("123456759", "99988877754"));
		cl2.getTelefones().addAll(Arrays.asList("987654321", "88855557754"));
		cl3.getTelefones().addAll(Arrays.asList("123456759"));
		
		Endereco e1 = new Endereco(null, "Rua 13 de Maio", "300", "Apto 123", "Bairro", "6165478-52", cl1, c1);
		Endereco e2 = new Endereco(null, "Domingos Olimpio", "300", "Casa 4501", "Parangaba", "6165478-52", cl2, c2);
		Endereco e3 = new Endereco(null, "Marco Pontes", "123", "Casa 7888", "Pq Veras", "6165478-52", cl2, c3);
		
		cl1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cl1, cl2, cl3));
		enderecoRepository.saveAll(Arrays.asList(e1,e2, e3));
	}
}
