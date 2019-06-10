package exceptions;

public class ContaSaldoInsuficienteException extends Exception{
	//private static final long serialVersionUID = 1L;
	public ContaSaldoInsuficienteException() {
		super("Saldo na conta é insuficiente.");
	}
}
