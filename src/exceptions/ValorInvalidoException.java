package exceptions;

public class ValorInvalidoException extends Exception {
	//private static final long serialVersionUID = 1L;
	public ValorInvalidoException() {
		super("Informe um valor maior ou igual a zero.");
	}
}
