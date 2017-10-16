package br.edu.up.autojava.dal;
import java.util.List;

public interface DAO<O> {
	
	public boolean adicionar(O o);
	public O buscar(Integer id);
	public List<O> listar();
	public boolean alterar(O o);
	public boolean remover(O o);

}
