package br.unicap.banco.model;

public class Cliente implements Comparable<Cliente> {
	private String nome;
	private String cpf;
	private int idade;
	private TipoCliente tipo;
	private Endereco endereco;
	
	public Cliente (String nome, String cpf, int idade, TipoCliente tipo, String bairro, String rua, int numero, String cep)  {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tipo = tipo;
		this.endereco = new Endereco(bairro, rua, numero, cep);
	}
	
	public Cliente() {}
	
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
	
	@Override
	public String toString() {
		return "Cliente [CPF= " +cpf+ ", Nome=" +nome+ ", Tipo=" +tipo+ ", Endereco=" +endereco+ "]";
	}

	@Override
	public int compareTo(Cliente arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
