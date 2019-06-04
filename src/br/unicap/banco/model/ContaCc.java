package br.unicap.banco.model;

public class ContaCc extends ContaAbstrata{
	public ContaCc(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public void debitar(double value) {
		setSaldo(getSaldo() - value);
	}
}
