package br.unicap.banco.model;

public interface IRep <E>{
	public void inserir(E e) throws Exception;
	public void atualizar(E e) throws Exception;
	public void remover(E e) throws Exception;
	public E consultar(String num) throws Exception;
}
