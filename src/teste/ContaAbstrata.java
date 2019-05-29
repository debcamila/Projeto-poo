package teste;

public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	private Cliente cliente;
	
	public ContaAbstrata(String numero, double saldo){
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void creditar(double value) {
		saldo = saldo + value;
	}
	
	public abstract void debitar(double value);
	
	public void transferir(double valor, ContaAbstrata c) {
		this.debitar(valor);
        c.creditar(valor);
	}
}
