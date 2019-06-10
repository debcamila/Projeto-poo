package br.unicap.banco.dados;

import br.unicap.banco.model.ContaAbstrata;
import br.unicap.banco.model.IRepContas;
import exceptions.ArrayCheioException;
import exceptions.ContaExisteException;
import exceptions.ContaNaoEncontradaException;

public class RepositorioContasArray implements IRepContas{
	private final int TAM_MAX = 100;
	private ContaAbstrata[] contas; //guardo as contas
	private int indice;
	
	public RepositorioContasArray() {
		contas = new ContaAbstrata[TAM_MAX]; //inicializa o data source e faz os metodos
		indice = 0;
	}
	
	private int consultarIndice(String numConta) {
		int i = 0;
		int ind = -1;
		if (contas != null) {
			for (ContaAbstrata c : contas) {
				if (c == null) {
					break;
				} else if (c.getNumero().equals(numConta)) {
					ind = i;
					break;
				}
				i = i + 1;
			}
		}
		return ind;
	}
	
	public boolean existe(String numConta) {
		boolean resp = false;
		int i = this.consultarIndice(numConta);
		if (i != -1) {
			resp = true;
		}
		return resp;
	}
	
	@Override
	public ContaAbstrata consultar(String numConta) throws Exception {
		ContaAbstrata c;

		if (existe(numConta)) {
			int i = this.consultarIndice(numConta);
			c = contas[i];
			return c;
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public void inserir(ContaAbstrata c) throws Exception {
		try {
			if (existe(c.getNumero()) == false) {
				contas[indice] = c;
				indice++;
			} else {
				throw new ContaExisteException();
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			throw new ArrayCheioException();
		}
	}

	@Override
	public void remover(ContaAbstrata c) throws Exception{
		if (existe(c.getNumero())) {
			int i = this.consultarIndice(c.getNumero());
			contas[i] = contas[indice - 1];
			contas[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public void atualizar(ContaAbstrata c) throws Exception {
		int i = consultarIndice(c.getNumero());
		if (i != -1) {
			contas[i] = c;
		} else {
			throw new ContaNaoEncontradaException();
		}
	}
}
