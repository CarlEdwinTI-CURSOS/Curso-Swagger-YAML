package br.com.alura.funcionarios.api.model;

import java.io.Serializable;
import java.util.Date;

public class Funciononario implements Serializable {

	private static final long serialVersionUID = 3269122206874553799L;

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
