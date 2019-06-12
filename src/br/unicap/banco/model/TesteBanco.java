package br.unicap.banco.model;

public class TesteBanco {

	public static void main(String[] args) {
		Fachada fachada = Fachada.obterInstancia();
		ContaAbstrata c1, c2;
		Cliente cli1, cli2;
		
		
		cli1 = new Cliente("Ada Lovelace", "123", 20, TipoCliente.VIP, "abc", "ba" , 125, "5353333");
		cli2 = new Cliente("Camila Achutti", "456", 21, TipoCliente.EXECUTIVO, "def", "ed" , 123, "5353311");
		
		c1 = new ContaImposto("123", 100, cli1);
		c2 = new ContaBonificada("456", 300, cli2);

	}

}
