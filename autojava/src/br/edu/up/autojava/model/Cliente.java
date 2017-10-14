package br.edu.up.autojava.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String apelido;
	private String documento; //CPF, RG OU CNPJ
	private String documento_tipo;
	private String sexo;
	private Date data_nascimento;
	private Date data_cadastro;
	private String cep;
	private String endereco;
	private String numero;
	private String bairro;
	private int id_cidade;
	private int id_estado;
	private String email;
	private int situacao;
	private String tipo; // Pessoa física ou jurídica
	
	// getters
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getApelido() {
		return apelido;
	}
	public String getDocumento() {
		return documento;
	}
	public String getDocumento_tipo() {
		return documento_tipo;
	}
	public String getSexo() {
		return sexo;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public String getCep() {
		return cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getNumero() {
		return numero;
	}
	public String getBairro() {
		return bairro;
	}
	public int getId_cidade() {
		return id_cidade;
	}
	public int getId_estado() {
		return id_estado;
	}
	public String getEmail() {
		return email;
	}
	public int getSituacao() {
		return situacao;
	}
	public String getTipo() {
		return tipo;
	}
	
	// setters
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public void setDocumento_tipo(String documento_tipo) {
		this.documento_tipo = documento_tipo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
