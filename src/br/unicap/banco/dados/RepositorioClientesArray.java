package br.unicap.banco.dados;

import br.unicap.banco.model.Cliente;

public class RepositorioClientesArray implements IRepClientes{
	private final int TAM_MAX = 100;
	private Cliente[] clientes; //guardo os clientes
	
	public RepositorioClientesArray() {
		clientes = new Cliente[TAM_MAX]; //inicializa o data source e faz os metodos
	}
	
	public void inserir (Cliente clientes) {
		
	}
	
	public void remover (String cpf) {
		
	}
	
	public void atualizar (Cliente clientes) {
		
	}
	
	public Cliente consultar (String cpf) {
		return null;
	}
}
