package br.edu.up.autojava.controller;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.up.autojava.model.Cliente;
import br.edu.up.autojava.dal.ClienteDAO;

@RequestScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean {

	public static ClienteDAO dao = new ClienteDAO();
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
		return dao.listar();
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String adicionar(Cliente cliente){
		if(dao.adicionar(cliente)){
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
		if(dao.alterar(cliente)){
			this.cliente = new Cliente();
			return "/Cliente/Listar.xhtml?faces-redirect=true";
		}else{
			return "/Cliente/Alterar.xhtml?faces-redirect=true";
		}
	}
	
	public void remover(Cliente cliente){
		if(dao.remover(cliente)){
			// Mensagem de sucesso
		}else{
			// Mensagem de falha
		}
	}

}
