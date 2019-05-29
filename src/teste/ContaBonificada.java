package teste;

public class ContaBonificada extends ContaCc{
	private double bonus; 
	
	public ContaBonificada(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void renderBonus() {
		super.creditar(bonus);
		this.bonus = 0;
	}
	
	public void creditar(double valor) { //overriding
		this.bonus = this.bonus + (valor * 0.01);
		super.creditar(valor);
	}
	
}
