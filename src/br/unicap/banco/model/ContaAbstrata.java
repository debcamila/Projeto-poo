package br.unicap.banco.model;

import exceptions.ContaSaldoInsuficienteException;

//toda vez que uma classe concreta herda de uma classe abstrata, se essa classe abstrata tiver metodos abstratos ela é 
//obrigada a implementar o metodo abstrato, se nao ela nao existe como objeto.

//classes abstratas obrigam comportamento, informacoes, propriedades para filhas pra garantir uma conformidade ->REUSO

//classe abstrata: não tem necessariamente metodos abstratos e pra que serve? REUSO, para todo mundo herde as caracteristicas.
//uma classe abstrata se TORNA abstrata quando tem metodos abstratos, mas nem sempre
//nao pode ser instanciada pq é abstrata
public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	private Cliente cliente;
	
	public ContaAbstrata() {}
	
	public ContaAbstrata(String numero, double saldo, Cliente cliente){
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	@Override
	public String toString() {
		return "ContaAbstrata [Número=" +numero+ ", Saldo=" +saldo+ ", Cliente=" +cliente+ "]";
	}
	
	public void creditar(double value) { 
		//pq implemento o metodo creditar? pq esse comportamento é comum para todos (ideia do reuso)
		saldo = saldo + value;
	}
	
	public abstract void debitar(double value) throws Exception;
	//como os filhos fazem o debitar diferente eu noa implemento.
	//tem diferença na forma que eu atriuo o valor do atributo = semantica
		
	public void transferir(ContaAbstrata c, double valor) throws Exception {
		try {
			this.debitar(valor);
			c.creditar(valor);
		}
		catch(ContaSaldoInsuficienteException e) {
			throw e;
		}
	}
	
	/* métodos para hashmap */
		@Override
		public boolean equals(Object obj) {
			boolean isEqual = false;
			if (obj instanceof ContaAbstrata) { 
				isEqual = this.getNumero().equals(((ContaAbstrata) obj).getNumero());
			}
			return isEqual;
		}

		@Override
		public int hashCode() {
			return this.getNumero().hashCode();
		}
}
