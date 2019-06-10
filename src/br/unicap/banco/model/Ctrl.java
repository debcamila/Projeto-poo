package br.unicap.banco.model;

public abstract class Ctrl<E> {
	public abstract void inserir(E e) throws Exception;
	public abstract void remover(E e) throws Exception;
	public abstract E consultar(String e) throws Exception;
	public abstract void atualizar(E e) throws Exception;
}
