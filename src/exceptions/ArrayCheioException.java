package exceptions;

public class ArrayCheioException extends Exception {
	//private static final long serialVersionUID = 1L;
	public ArrayCheioException() {
		super("Não possui espaço suficiente no repositório");
	}

}
