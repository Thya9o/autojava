package br.edu.up.autojava.controller;

import java.util.ArrayList;
import java.util.List;

/*import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;*/

import br.edu.up.autojava.dal.ClienteDAO;
import br.edu.up.autojava.model.Cliente;

/*@RequestScoped
@ManagedBean(name = "clienteBean")*/

public class ClienteBean {


	private Cliente cliente = new Cliente();
	
	@SuppressWarnings("unused")
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return ClienteDAO.listar();
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String adicionar(Cliente cliente){
		if(ClienteDAO.adicionar(cliente)){
			this.cliente = new Cliente();
			return "/Cliente/Listar.xhtml?faces-redirect=true";
		}else{
			return "/Cliente/Cadastrar.xhtml?faces-redirect=true";
		}
	}
	
	public String enviaDados(Cliente cliente){
		this.cliente = cliente;
		return "/Cliente/Alterar.xhtml?faces-redirect=true";
	}
	
	public String alterar(Cliente cliente){
		if(ClienteDAO.alterar(cliente)){
			this.cliente = new Cliente();
			return "/Cliente/Listar.xhtml?faces-redirect=true";
		}else{
			return "/Cliente/Alterar.xhtml?faces-redirect=true";
		}
	}
	
	public void remover(Cliente cliente){
		if(ClienteDAO.remover(cliente)){
			// Mensagem de sucesso
		}else{
			// Mensagem de falha
		}
	}

}
