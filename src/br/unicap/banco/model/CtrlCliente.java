package br.unicap.banco.model;

import exceptions.ArrayCheioException;
import exceptions.ClienteExisteException;
import exceptions.ClienteNaoEncontradoException;

public class CtrlCliente extends Ctrl<Cliente> {
	private IRepClientes clientes;
	
	public CtrlCliente (IRepClientes rep) {
		this.clientes = rep;
	}
	
	@Override
	public Cliente consultar(String cpf) throws Exception {
		try {
			return clientes.consultar(cpf);
		}catch(ClienteNaoEncontradoException e) {
			throw e;
		}
	}
	
	@Override
	public void inserir(Cliente cliente) throws Exception {
		try {
			clientes.inserir(cliente);

		} catch (ClienteExisteException | ArrayCheioException e) {
			throw e;
		}
	}
	
	@Override
	public void remover(Cliente cliente) throws Exception {
		try {
			clientes.remover(cliente);
		}catch(ClienteNaoEncontradoException e) {
			
		}
	}
	
	@Override
    public void atualizar(Cliente cliente) throws Exception{
    	try {
    		clientes.atualizar(cliente);
    	}catch(ClienteNaoEncontradoException e) {
    		throw e;
    	}
    }
}
