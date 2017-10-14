package br.edu.up.autojava.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String placa;
	private String marca;
	private String modelo;
	private String ano;
	private String cor;
	private String detalhes; // Detalhes e características adicionais do veículo
	
	// getters
	public Integer getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getAno() {
		return ano;
	}
	public String getCor() {
		return cor;
	}
	public String getDetalhes() {
		return detalhes;
	}
	
	// setters
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	// Verifica se o veiculo é valido (create/update)
	public boolean validate() {
		if(this.getPlaca() == null) {
			return false;
		}
		return true;
	}
}
