package br.edu.up.autojava.controller;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.up.autojava.model.Veiculo;
import br.edu.up.autojava.dal.VeiculoDAO;

@RequestScoped
@ManagedBean(name = "veiculoBean")
public class VeiculoBean {
	
	public static VeiculoDAO dao = new VeiculoDAO();
	private Veiculo veiculo = new Veiculo();
	
	@SuppressWarnings("unused")
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return dao.listar();
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public String adicionar(Veiculo veiculo){
		if(dao.adicionar(veiculo)){
			this.veiculo = new Veiculo();
			return "/Veiculo/Listar.xhtml?faces-redirect=true";
		}else{
			return "/Veiculo/Cadastrar.xtml?faces-redirect=true";
		}
	}
	
	public String enviaDados(Veiculo veiculo){
		this.veiculo = veiculo;
		return "/Veiculo/Alterar.xhtml?faces-redirect=true";
	}
	
	public String alterar(Veiculo veiculo){
		if(dao.alterar(veiculo)){
			this.veiculo = new Veiculo();
			return "/Veiculo/Listar.xhtml?faces-redirect=true";
		}else{
			return "/Veiculo/Alterar.xhtml?faces-redirect=true";
		}
	}
	
	public void remover(Veiculo veiculo){
		if(dao.remover(veiculo)){
			// Mensagem de sucesso
		}else{
			// Mensagem de falha
		}
	}


}
