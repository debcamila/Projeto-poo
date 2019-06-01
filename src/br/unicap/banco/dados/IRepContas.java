package br.unicap.banco.dados;

import br.unicap.banco.model.ContaAbstrata;

public interface IRepContas { //todos os metodos de uma interface sao PUBLICOS e ABSTRATOS

	void inserir (ContaAbstrata conta);
	
	void remover (String numero);
	
	void atualizar (ContaAbstrata conta);
	
	ContaAbstrata consultar (String numero);
}
