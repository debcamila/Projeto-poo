package br.unicap.banco.model;

import br.unicap.banco.dados.RepositorioClientesArray;
import br.unicap.banco.dados.RepositorioContasArray;
import exceptions.ArrayCheioException;
import exceptions.ClienteExisteException;
import exceptions.ClienteNaoEncontradoException;
import exceptions.ContaExisteException;
import exceptions.ContaNaoEncontradaException;
import exceptions.ContaSaldoInsuficienteException;
import exceptions.ValorInvalidoException;

public class Fachada {
	private static Fachada instancia;
	private CtrlConta contas;
	private CtrlCliente clientes;
	
	public static Fachada obterInstancia() {
		if(instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	
	private Fachada() {
		initCadastros();
	}
	
	private void initCadastros() {
		RepositorioContasArray repContas = new RepositorioContasArray();
		contas = new CtrlConta(repContas);
		
		RepositorioClientesArray repClientes = new RepositorioClientesArray();
		clientes = new CtrlCliente(repClientes);
	}
	
	//métodos para clientes
	public void cadastrarCliente(Cliente c) throws Exception {
		try {
			clientes.inserir(c);
		}
		catch(ArrayCheioException | ClienteExisteException e) {
			e.getMessage();
		}
	}
	
	public void removerCliente(Cliente c) throws Exception {
		try {
			clientes.remover(c);
		}
		catch(ClienteNaoEncontradoException e) {
			e.getMessage();
		}
	}
	
	public void atualizarCliente(Cliente c) throws Exception {
		try {
			clientes.atualizar(c);
		}catch(ClienteNaoEncontradoException e) {
			e.getMessage();
		}
	}
	
	public Cliente consultarCliente(String cpf) throws Exception {
		try {
			clientes.consultar(cpf);
		}
		catch(ClienteNaoEncontradoException e) {
			e.getMessage();
		}
		return null;
	}
	
	//métodos para contas
	public void cadastrarConta(ContaAbstrata c) throws Exception {
		try {
			contas.inserir(c);
		}
		catch(ArrayCheioException | ContaExisteException e) {
			e.getMessage();
		}
	}
	
	public void removerConta(ContaAbstrata c) throws Exception {
		try {
			contas.remover(c);
		}
		catch(ContaNaoEncontradaException e) {
			e.getMessage();
		}
	}
	
	public void atualizarConta(ContaAbstrata c) throws Exception {
		try {
			contas.atualizar(c);
		}
		catch(ContaNaoEncontradaException e) {
			e.getMessage();
		}
	}
	
	public ContaAbstrata consultarConta(String num) throws Exception {
		try {
			return contas.consultar(num);
		}
		catch(ContaNaoEncontradaException e) {
			e.getMessage();
		}
		return null;
	}
	
	public void creditar(String num, double valor) throws Exception {
		try {
			contas.creditar(num, valor);
		}
		catch(ContaNaoEncontradaException | ValorInvalidoException e) {
			e.getMessage();
		}
	}
	
	public void debitar(String n, double valor) throws Exception {
		try {
			contas.debitar(n, valor);
		}
		catch(ContaNaoEncontradaException | ContaSaldoInsuficienteException e) {
			e.getMessage();
		}
	}
	
	public void transferir(String origem, String destino, double valor) throws Exception {
		try {
			ContaAbstrata o = contas.consultar(origem);
			ContaAbstrata d = contas.consultar(destino);

			if (o != null && d != null) {
				o.transferir(d, valor);
			}
		}
		catch(ContaNaoEncontradaException | ContaSaldoInsuficienteException e) {
			e.getMessage();
		}
	}
	
	
}
