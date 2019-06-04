package br.unicap.banco.model;

public class ContaImposto extends ContaAbstrata{
	
	private final double IMPOSTO = 0.01;
	
	public void debitar(double value) {
		double calculaImposto = IMPOSTO * value;
		this.setSaldo(getSaldo() - (calculaImposto + IMPOSTO));
	}
}
