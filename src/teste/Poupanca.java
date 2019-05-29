package teste;

public class Poupanca extends ContaCc{
	public Poupanca(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public void renderJuros(double taxa) {
		double saldoAtual = getSaldo();
		creditar(saldoAtual * taxa);
	}
}
