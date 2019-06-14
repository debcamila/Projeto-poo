package br.unicap.banco.model;

import java.util.Scanner;

import br.unicap.banco.dados.RepClienteTreeSet;
import br.unicap.banco.dados.RepContaMap;

public class TesteBanco {

	public static void main(String[] args) {
		Fachada fachada = Fachada.obterInstancia();
		ContaAbstrata c1, c2;
		Cliente cli1, cli2;
		
		cli1 = new Cliente("Ada Lovelace", "123", 20, TipoCliente.VIP, "abc", "ba" , 125, "5353333");
		System.out.println(cli1.toString());
		cli2 = new Cliente("Camila Achutti", "456", 21, TipoCliente.EXECUTIVO, "def", "ed" , 123, "5353311");
		System.out.println(cli2.toString());
		
		c1 = new ContaImposto("123", 100, cli1);
		System.out.println(c1.toString());
		
		
		c2 = new ContaBonificada("456", 300, cli2);
		System.out.println(c2.toString());
		
		try {
			fachada.cadastrarConta(c1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		/* Usando os metodos do HashMap*/
		RepContaMap repoConta = new RepContaMap();
		Cliente cliente = new Cliente("Bruna", "1313", 19, TipoCliente.VIP, "jiji", "bo", 222, "ap");
		ContaAbstrata conta = new ContaBonificada("1515", 3000, cliente);
		repoConta.inserir(conta);
		conta.creditar(100);
		
		
		/* Usando TreeSet */
		RepClienteTreeSet repoCliente = new RepClienteTreeSet();
		Cliente clienteTree = new Cliente("Amanda", "1212", 18, TipoCliente.EXECUTIVO, "huhu", "ju" , 888, "909090");
		
		repoCliente.inserir(clienteTree);
		System.out.println("Cliente novo adicionado");
		System.out.println(repoCliente.consultar(clienteTree.getCpf()));
		
		clienteTree.setNome("Amanda Mudada");
		repoCliente.atualizar(clienteTree);
		System.out.println("Cliente atualizado");
		System.out.println(repoCliente.consultar(clienteTree.getCpf()));
	}

}
