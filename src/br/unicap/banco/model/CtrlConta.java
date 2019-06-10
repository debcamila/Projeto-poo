package br.unicap.banco.model;

import exceptions.ArrayCheioException;
import exceptions.ContaExisteException;
import exceptions.ContaNaoEncontradaException;
import exceptions.ContaSaldoInsuficienteException;
import exceptions.ValorInvalidoException;

public class CtrlConta extends Ctrl<ContaAbstrata> {
	private IRepContas contas;
	
	public CtrlConta (IRepContas rep) {
		this.contas = rep;
	}
	
	@Override
	public ContaAbstrata consultar(String numeroConta) throws Exception {
		try {
			return contas.consultar(numeroConta);
		} catch (ContaNaoEncontradaException e) {
			throw e;
		}
	}
	
	@Override
	public void inserir(ContaAbstrata conta) throws Exception {
		try {
			contas.inserir(conta);
		} catch (ContaExisteException | ArrayCheioException e) {
			throw e;
		}
	}
	
	@Override
	public void remover(ContaAbstrata conta) throws Exception {
		try {
			contas.remover(conta);
		} catch (ContaNaoEncontradaException e) {
			throw e;
		}
	}
	
	@Override
	public void atualizar(ContaAbstrata conta) throws Exception {
		try {
			contas.atualizar(conta);
		} catch (ContaNaoEncontradaException e) {
			throw e;
		}
	}
	
	public void creditar(String numero, double valor) throws Exception {
		if (valor > 0) {
			if (contas.consultar(numero) != null) {
				ContaAbstrata conta = consultar(numero);
				conta.creditar(valor);
				contas.atualizar(conta);
			} else {
				throw new ContaNaoEncontradaException();
			}
		} else {
			throw new ValorInvalidoException();
		}
	}
	
	public void debitar(String numeroConta, double valor) throws Exception {
		try {
			if (contas.consultar(numeroConta) != null) {
				ContaAbstrata conta = consultar(numeroConta);
				conta.debitar(valor);
			} else {
				throw new ContaNaoEncontradaException();
			}
		} catch (ContaSaldoInsuficienteException e) {
			throw e;
		}
	}
	
	public void transferir(String origem, String destino, double valor) throws Exception {
		try {
			ContaAbstrata o = consultar(origem);
			ContaAbstrata d = consultar(destino);
			o.transferir(d, valor);
		} catch (ContaNaoEncontradaException | ContaSaldoInsuficienteException e) {
			throw e;
		}
	}
}
