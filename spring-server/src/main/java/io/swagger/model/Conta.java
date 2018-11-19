package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Cliente;
import io.swagger.model.Transacao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Conta
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-27T23:17:19.797Z")

public class Conta   {
  @JsonProperty("agencia")
  private Integer agencia = null;

  @JsonProperty("numero")
  private Long numero = null;

  @JsonProperty("digito")
  private Integer digito = null;

  @JsonProperty("saldo")
  private Double saldo = null;

  @JsonProperty("cliente")
  private Cliente cliente = null;

  @JsonProperty("transacoes")
  @Valid
  private List<Transacao> transacoes = null;

  public Conta agencia(Integer agencia) {
    this.agencia = agencia;
    return this;
  }

  /**
   * Get agencia
   * @return agencia
  **/
  @ApiModelProperty(example = "975", value = "")


  public Integer getAgencia() {
    return agencia;
  }

  public void setAgencia(Integer agencia) {
    this.agencia = agencia;
  }

  public Conta numero(Long numero) {
    this.numero = numero;
    return this;
  }

  /**
   * Get numero
   * @return numero
  **/
  @ApiModelProperty(example = "784563", value = "")


  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public Conta digito(Integer digito) {
    this.digito = digito;
    return this;
  }

  /**
   * Get digito
   * @return digito
  **/
  @ApiModelProperty(example = "7", value = "")


  public Integer getDigito() {
    return digito;
  }

  public void setDigito(Integer digito) {
    this.digito = digito;
  }

  public Conta saldo(Double saldo) {
    this.saldo = saldo;
    return this;
  }

  /**
   * Get saldo
   * @return saldo
  **/
  @ApiModelProperty(example = "101.34", value = "")


  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public Conta cliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  /**
   * Get cliente
   * @return cliente
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Conta transacoes(List<Transacao> transacoes) {
    this.transacoes = transacoes;
    return this;
  }

  public Conta addTransacoesItem(Transacao transacoesItem) {
    if (this.transacoes == null) {
      this.transacoes = new ArrayList<Transacao>();
    }
    this.transacoes.add(transacoesItem);
    return this;
  }

  /**
   * Get transacoes
   * @return transacoes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Transacao> getTransacoes() {
    return transacoes;
  }

  public void setTransacoes(List<Transacao> transacoes) {
    this.transacoes = transacoes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Conta conta = (Conta) o;
    return Objects.equals(this.agencia, conta.agencia) &&
        Objects.equals(this.numero, conta.numero) &&
        Objects.equals(this.digito, conta.digito) &&
        Objects.equals(this.saldo, conta.saldo) &&
        Objects.equals(this.cliente, conta.cliente) &&
        Objects.equals(this.transacoes, conta.transacoes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agencia, numero, digito, saldo, cliente, transacoes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Conta {\n");
    
    sb.append("    agencia: ").append(toIndentedString(agencia)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    digito: ").append(toIndentedString(digito)).append("\n");
    sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("    transacoes: ").append(toIndentedString(transacoes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

