package br.unicap.banco.model;

public class Poupanca extends ContaCc{
	
	private final double taxa = 0.01;
	
	public Poupanca(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public void renderJuros() {
		creditar(getSaldo() * taxa);
	}
}
