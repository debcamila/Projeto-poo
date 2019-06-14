package br.unicap.banco.dados;

import java.util.TreeSet;

import br.unicap.banco.model.IRepClientes;
import br.unicap.banco.model.Cliente;

public class RepClienteTreeSet implements IRepClientes {
	private TreeSet<Cliente> clientes;
	
	public RepClienteTreeSet() {
		clientes = new TreeSet<>();
	}
	
	@Override
	public Cliente consultar(String cpf) {
		// TODO Auto-generated method stub
		for (Cliente c : clientes) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public void inserir(Cliente c) {
		// TODO Auto-generated method stub
		clientes.add(c); //tem que fazer o tratamento de exceções
	}
	
	@Override
	public void remover(Cliente c) {
		// TODO Auto-generated method stub
		for (Cliente cli : clientes) {
			if(cli.getCpf().equals(c.getCpf())) {
				clientes.remove(cli);
				return;
			}
		}
	}
	
	@Override
	public void atualizar(Cliente c) {
		// TODO Auto-generated method stub
		if (clientes.contains(c)) {
			clientes.remove(c);
			clientes.add(c);
		}
	}
}
