package br.unicap.banco.dados;

import br.unicap.banco.model.Cliente;
import br.unicap.banco.model.IRepClientes;
import exceptions.ArrayCheioException;
import exceptions.ClienteExisteException;
import exceptions.ClienteNaoEncontradoException;

public class RepositorioClientesArray implements IRepClientes{
	private final int TAM_MAX = 100;
	private Cliente[] clientes; //guardo os clientes
	private int indice;
	
	public RepositorioClientesArray() {
		clientes = new Cliente[TAM_MAX]; //inicializa o data source e faz os metodos
		indice = 0;
	}
	
	private int consultarIndice(String cpf) {
		int i = 0;
		int ind = -1;
		if (clientes != null) {
			for (Cliente cli : clientes) {
				if (cli == null) {
					break;
				} 
				else if (cli.getCpf().equals(cpf)) {
					ind = i;
					break;
				}

				i = i + 1;
			}
		}
		return ind;
	}
	
	public boolean existe(String cpf) {
		boolean resp = false;
		int i = this.consultarIndice(cpf);
		if (i != -1) {
			resp = true;
		}
		return resp;
	}
	
	public Cliente consultar (String cpf) throws Exception{
		Cliente cli;
		if(existe(cpf)) {
			int i = this.consultarIndice(cpf);
			cli = clientes[i];
			return cli;
		}
		else {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public void inserir (Cliente cli) throws Exception{
		try {
			if(existe(cli.getCpf() == false)) {
				clientes[indice] = cli;
				indice = indice + 1;
			}
			else {
				throw new ClienteExisteException();
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayCheioException();
		}
	}
	
	public void remover (Cliente cli) throws Exception {
		if (existe(cli.getCpf())) {
			int i = this.consultarIndice(cli.getCpf());
			clientes[i] = clientes[indice - 1];
			clientes[indice - 1] = null;
			indice = indice - 1;
		}
		else {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public void atualizar (Cliente cli) throws Exception {
		int i = consultarIndice(cli.getCpf());
		if (i != -1) {
			clientes[i] = cli;
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
}
