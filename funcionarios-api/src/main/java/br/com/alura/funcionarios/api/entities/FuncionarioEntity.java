package br.com.alura.funcionarios.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario_db")
public class FuncionarioEntity implements Serializable {

	private static final long serialVersionUID = 7763615184644648216L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private Double salario;
	
	private Date dataContratacao;

	public FuncionarioEntity() {
	}
	
	public FuncionarioEntity(String nome, Date dataNascimento, Double salario, Date dataContratacao) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
	}

	public FuncionarioEntity(Long id, String nome, Date dataNascimento, Double salario, Date dataContratacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
	}

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
