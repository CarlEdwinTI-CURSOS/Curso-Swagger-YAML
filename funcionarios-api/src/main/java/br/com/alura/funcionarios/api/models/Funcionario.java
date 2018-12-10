package br.com.alura.funcionarios.api.models;

import java.io.Serializable;
import java.util.Date;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = -5507712654246606206L;

	private Long id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private Double salario;
	
	private Date dataContratacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
}
