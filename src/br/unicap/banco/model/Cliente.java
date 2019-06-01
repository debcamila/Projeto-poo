package br.unicap.banco.model;

public class Cliente {
	private String nome;
	private String cpf;
	private int idade;
	private TipoCliente tipo;
	private Endereco endereco;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public TipoCliente getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
}
