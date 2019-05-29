package teste;

public class ContaImposto extends ContaAbstrata{
	
	private double imposto = 0.01;
	
	public ContaImposto(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public void debitar(double value) {
		double v = value * imposto;
		setSaldo(getSaldo() - value - v);
	}
}
