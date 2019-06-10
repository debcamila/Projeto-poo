package br.unicap.banco.model;

public class Endereco {
	private String bairro;
	private String rua;
	private int numero;
	private String cep;
	
	public Endereco(String bairro, String rua, int numero, String cep) {
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCep() {
		return cep;
	}
}
