package br.unicap.banco.model;

public class ContaBonificada extends ContaCc{
	private double bonus; 
	private final double taxaBonus = 0.02;
	
	public ContaBonificada(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void creditar(double valor) { //overriding, sem ferir a semantica, faz a mesma coisa com algo a mais
		this.bonus = this.bonus + (valor * taxaBonus);
		super.creditar(valor);
	}
	
	public void renderBonus() { //credita o bonus acumulado ao longo dos creditos na conta
		super.creditar(bonus);
		this.bonus = 0;
	}
	
}
