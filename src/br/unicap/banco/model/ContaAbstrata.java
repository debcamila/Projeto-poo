package br.unicap.banco.model;

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
	
	public ContaAbstrata(String numero, double saldo){
		this.numero = numero;
		this.saldo = saldo;
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
	
	public void creditar(double value) { 
		//pq implemento o metodo creditar? pq esse comportamento é comum para todos (ideia do reuso)
		saldo = saldo + value;
	}
	
	public abstract void debitar(double value);
	//como os filhos fazem o debitar diferente eu noa implemento.
	//tem diferença na forma que eu atriuo o valor do atributo = semantica
		
	public void transferir(double valor, ContaAbstrata c) {
		this.debitar(valor);
        c.creditar(valor);
	}
}
