package br.unicap.banco.model;

public class Poupanca extends ContaCc{
	
	private final double TAXA = 0.01;
	
	public Poupanca(String numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}
	
	public Poupanca() {}
	
	public void renderJuros() {
		creditar(getSaldo() * TAXA);
	}
}
