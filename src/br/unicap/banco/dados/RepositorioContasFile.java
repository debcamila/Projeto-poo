package br.unicap.banco.dados;
import java.io.File;
import br.unicap.banco.model.ContaAbstrata;

public class RepositorioContasFile implements IRepContas{
	private String pathFile = "c://...";
	private File arquivo;
	
	public void inserir (ContaAbstrata conta) {}
	
	public void remover (String numero) {}
	
	public void atualizar (ContaAbstrata conta) {}
	
	public ContaAbstrata consultar (String numero) {
		return null;}
	
}
