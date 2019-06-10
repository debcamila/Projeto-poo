package exceptions;

public class ClienteExisteException extends Exception {
	//private static final long serialVersionUID = 1L;
	public ClienteExisteException() {
		super("O cliente já existe.");
	}
}
