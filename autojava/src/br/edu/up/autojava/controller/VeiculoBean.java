package br.com.autosolutions.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.autosolutions.dal.VeiculoDAO;
import br.com.autosolutions.model.Veiculo;

@RequestScoped
@ManagedBean(name = "veiculoBean")
public class VeiculoBean {
	
	
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
		return VeiculoDAO.listar();
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public String adicionar(Veiculo veiculo){
		if(VeiculoDAO.adicionar(veiculo)){
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
		if(VeiculoDAO.alterar(veiculo)){
			this.veiculo = new Veiculo();
			return "/Veiculo/Listar.xhtml?faces-redirect=true";
		}else{
			return "/Veiculo/Alterar.xhtml?faces-redirect=true";
		}
	}
	
	public void remover(Veiculo veiculo){
		if(VeiculoDAO.remover(veiculo)){
			// Mensagem de sucesso
		}else{
			// Mensagem de falha
		}
	}


}
