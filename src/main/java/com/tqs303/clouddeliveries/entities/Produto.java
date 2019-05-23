package com.tqs303.clouddeliveries.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idProduto;

  private String tipo;
  private int quantidade;

  @ManyToOne(cascade = CascadeType.ALL)
  private Pedido pedido;

  public Produto() {}

  public Produto(String tipo, int quantidade) {
    this.tipo = tipo;
    this.quantidade = quantidade;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public int getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }
}
