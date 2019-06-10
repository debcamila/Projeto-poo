package br.unicap.banco.model;

import exceptions.ContaSaldoInsuficienteException;

public class ContaCc extends ContaAbstrata{
	public ContaCc(String numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}
	
	public ContaCc() {}
	
	public void debitar(double value) throws Exception {
		if (getSaldo() >= value) {
            setSaldo(getSaldo() - value);
        } else {
            throw new ContaSaldoInsuficienteException();
        }
	}
}
