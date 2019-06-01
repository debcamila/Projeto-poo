package br.unicap.banco.dados;

import br.unicap.banco.model.Cliente;

public interface IRepClientes {
	void inserir (Cliente cliente);
	
	void remover (String cpf);
	
	void atualizar (Cliente cliente);
	
	Cliente consultar (String cpf);
}
