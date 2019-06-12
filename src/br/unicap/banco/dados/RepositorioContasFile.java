package br.unicap.banco.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import br.unicap.banco.model.ContaAbstrata;
import br.unicap.banco.model.IRepContas;
import exceptions.ContaExisteException;
import exceptions.ContaNaoEncontradaException;

public class RepositorioContasFile implements IRepContas {
	private static String ARQUIVO = "contas.txt";
	private Map<String, ContaAbstrata> contas;
	private ObjectInputStream input;
    private ObjectOutputStream output;
	
	public RepositorioContasFile() throws Exception {
		manipularOjeto();
	}
	
	private void sincronizarObjeto() throws Exception {
		contas = lerObjeto();
	}
	
	public boolean existe(ContaAbstrata c) throws Exception {
		sincronizarObjeto();
		return contas.containsKey(c.getNumero());
	}
	
	private void manipularOjeto() throws Exception {
		File arq = new File(ARQUIVO);
		if(!arq.exists()) {
			contas = new HashMap<>();
			gravarObjeto(contas);			
		}
		else {
			contas = lerObjeto();
		}
	}

	
	@Override
	public void inserir (ContaAbstrata c) throws Exception {
		if(!existe(c)) {
			contas.put(c.getNumero(), c);
			gravarObjeto(contas);
		}
		else {
			throw new ContaExisteException();
		}
	}
	
	@Override
	public void remover (ContaAbstrata c) throws Exception {
		if(existe(c)) {
			contas.remove(c.getNumero(), c);
			gravarObjeto(contas);
		}
		else {
			throw new ContaNaoEncontradaException();
		}
	}
	
	@Override
	public void atualizar (ContaAbstrata c) throws Exception {
		if (existe(c)) {
			contas.put(c.getNumero(), c);
			gravarObjeto(contas);
		} else {
			throw new ContaNaoEncontradaException();
		}
	}
	
	@Override
	public ContaAbstrata consultar (String num) throws Exception {
		sincronizarObjeto();
		return contas.get(num);
	}
	
	public void gravarObjeto(Map<String, ContaAbstrata> contas) throws Exception {        
        try {
        	FileOutputStream arq = new FileOutputStream(ARQUIVO);
	        output = new ObjectOutputStream(arq);
	        output.writeObject(contas); 
        }
        catch (IOException e){
        	throw e;
        }
	}
	
	private Map<String, ContaAbstrata> lerObjeto() throws Exception {
		Map<String, ContaAbstrata> result;
		
		try {
			FileInputStream arq = new FileInputStream(ARQUIVO);
            input = new ObjectInputStream(arq);
            result = (Map<String, ContaAbstrata>) input.readObject();
		}catch(IOException e) {
        	throw e;
		}
		return result;
	}
	
}
