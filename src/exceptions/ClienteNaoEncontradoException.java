package exceptions;

public class ClienteNaoEncontradoException extends Exception{
	//private static final long serialVersionUID = 1L;
	public ClienteNaoEncontradoException() {
		super(" O cliente n�o foi encontrado.");
	}
}
