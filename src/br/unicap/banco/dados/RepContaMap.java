package br.unicap.banco.dados;

import java.util.HashMap;

import br.unicap.banco.model.IRepContas;
import br.unicap.banco.model.ContaAbstrata;

public class RepContaMap implements IRepContas{
	private HashMap<String, ContaAbstrata> contas;
	private static int CAPACIDADE = 30;
	
	public RepContaMap() {
		contas = new HashMap<>(CAPACIDADE);
	}
	
	@Override
	public ContaAbstrata consultar(String num) {
		return contas.get(num);
	}
	
	public boolean existe(String num) {
		return contas.containsKey(num);
	}
	
	@Override
	public void inserir(ContaAbstrata c) {
		String key = c.getNumero();
		if (!contas.containsKey(key)){
			contas.put(key, c);
		}
	}
	
	@Override
	public void remover(ContaAbstrata c) {
		contas.remove(c);
	}
	
	public void atualizar(ContaAbstrata c) {
		contas.replace(c.getNumero(), c);
	}
}
