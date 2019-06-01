package br.unicap.banco.dados;

import br.unicap.banco.model.ContaAbstrata;

public class RepositorioContasArray implements IRepContas{
	private final int TAM_MAX = 100;
	private ContaAbstrata[] contas; //guardo as contas
	
	public RepositorioContasArray() {
		contas = new ContaAbstrata[TAM_MAX]; //inicializa o data source e faz os metodos
	}

	@Override
	public void inserir(ContaAbstrata conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(ContaAbstrata conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContaAbstrata consultar(String numero) {
		// TODO Auto-generated method stub
		return null;
	}
}
