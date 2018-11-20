package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Conta;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transacao
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-27T23:17:19.797Z")

public class Transacao   {
  @JsonProperty("id")
  private Long id = null;

  /**
   * Gets or Sets tipo
   */
  public enum TipoEnum {
    DEBITO("debito"),
    
    DEPOSITO("deposito");

    private String value;

    TipoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoEnum fromValue(String text) {
      for (TipoEnum b : TipoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipo")
  private TipoEnum tipo = null;

  @JsonProperty("valor")
  private Double valor = null;

  @JsonProperty("data")
  private OffsetDateTime data = null;

  @JsonProperty("conta")
  private Conta conta = null;

  public Transacao id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transacao tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  **/
  @ApiModelProperty(value = "")


  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }

  public Transacao valor(Double valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Get valor
   * @return valor
  **/
  @ApiModelProperty(value = "")


  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Transacao data(OffsetDateTime data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getData() {
    return data;
  }

  public void setData(OffsetDateTime data) {
    this.data = data;
  }

  public Transacao conta(Conta conta) {
    this.conta = conta;
    return this;
  }

  /**
   * Get conta
   * @return conta
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transacao transacao = (Transacao) o;
    return Objects.equals(this.id, transacao.id) &&
        Objects.equals(this.tipo, transacao.tipo) &&
        Objects.equals(this.valor, transacao.valor) &&
        Objects.equals(this.data, transacao.data) &&
        Objects.equals(this.conta, transacao.conta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tipo, valor, data, conta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transacao {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    conta: ").append(toIndentedString(conta)).append("\n");
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

