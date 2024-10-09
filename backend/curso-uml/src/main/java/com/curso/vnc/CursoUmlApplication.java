package com.curso.vnc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.vnc.domain.Categoria;
import com.curso.vnc.domain.Cidade;
import com.curso.vnc.domain.Cliente;
import com.curso.vnc.domain.Endereco;
import com.curso.vnc.domain.Estado;
import com.curso.vnc.domain.ItemPedido;
import com.curso.vnc.domain.Pagamento;
import com.curso.vnc.domain.PagamentoComBoleto;
import com.curso.vnc.domain.PagamentoComCartao;
import com.curso.vnc.domain.Pedido;
import com.curso.vnc.domain.Produto;
import com.curso.vnc.domain.enums.EstadoPagamento;
import com.curso.vnc.domain.enums.TipoCliente;
import com.curso.vnc.repositories.CategoriaRepository;
import com.curso.vnc.repositories.CidadeRepository;
import com.curso.vnc.repositories.ClienteRepository;
import com.curso.vnc.repositories.EnderecoRepository;
import com.curso.vnc.repositories.EstadoRepository;
import com.curso.vnc.repositories.ItemPedidoRepository;
import com.curso.vnc.repositories.PagamentoRepository;
import com.curso.vnc.repositories.PedidoRepository;
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

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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

		Cliente cl1 = new Cliente(null, "Marisa Silva", "mariasilva@gmail.com", "111111111-11",
				TipoCliente.PESSOAFISICA);
		Cliente cl2 = new Cliente(null, "João Marcos", "joaoa@gmail.com", "222222222-11", TipoCliente.PESSOAFISICA);
		Cliente cl3 = new Cliente(null, "Ana Cecilia Dantas", "ana@gmail.com", "333333333-33",
				TipoCliente.PESSOAJURIDICA);

		cl1.getTelefones().addAll(Arrays.asList("123456759", "99988877754"));
		cl2.getTelefones().addAll(Arrays.asList("987654321", "88855557754"));
		cl3.getTelefones().addAll(Arrays.asList("123456759"));

		Endereco e1 = new Endereco(null, "Rua 13 de Maio", "300", "Apto 123", "Bairro", "6165478-52", cl1, c1);
		Endereco e2 = new Endereco(null, "Domingos Olimpio", "300", "Casa 4501", "Parangaba", "6165478-52", cl2, c2);
		Endereco e3 = new Endereco(null, "Marco Pontes", "123", "Casa 7888", "Pq Veras", "6165478-52", cl2, c3);

		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cl1, cl2, cl3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/01/2024 11:25"), cl1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("17/03/2024 16:00"), cl2, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("10/03/2024 16:00"), cl2, e3);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PEDENTE, ped2, sdf.parse("20/03/2024 00:00"),
				null);
		ped2.setPagamento(pag2);
		Pagamento pag3 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped3, sdf.parse("20/03/2024 00:00"),
				sdf.parse("15/03/2024 13:00"));
		ped3.setPagamento(pag3);

		cl1.getPedidos().addAll(Arrays.asList(ped1));
		cl2.getPedidos().addAll(Arrays.asList(ped2, ped3));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2, pag3));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2= new ItemPedido(ped2, p2, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped3, p3, 100.00, 1, 800.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1));
		ped2.getItems().addAll(Arrays.asList(ip2, ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
