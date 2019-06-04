package br.unicap.banco.model;

public class Endereco {
	private String cidade;
	private String estado;
	private String bairro;
	private String rua;
	private String numero;
	private String cep;
	
	public Endereco(String cidade, String estado, String bairro, String rua, String numero, String cep) {
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
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
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCep() {
		return cep;
	}
}
