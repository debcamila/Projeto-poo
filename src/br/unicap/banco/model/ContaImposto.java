package br.unicap.banco.model;

import exceptions.ContaSaldoInsuficienteException;

public class ContaImposto extends ContaAbstrata {
	private final double IMPOSTO = 0.01;
	
	public ContaImposto(String numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}
	
	public void debitar(double value) throws Exception {
		double calculaImposto = IMPOSTO * value;
		if (getSaldo() >= value + IMPOSTO) {
			this.setSaldo(getSaldo() - (calculaImposto + IMPOSTO));
		} 
		else {
			throw new ContaSaldoInsuficienteException();
		}
	}
}
