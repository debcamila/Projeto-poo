package exceptions;

public class ContaNaoEncontradaException extends Exception {
	//private static final long serialVersionUID = 1L;
	public ContaNaoEncontradaException() {
		super("A conta n�o foi encontrada.");
	}
}
