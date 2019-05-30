package com.tqs303.clouddeliveries.entities;

import javax.persistence.*;
import java.util.List;

/** @author Diego */
// TODO calcular preço segundo peso
@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idPedido;

  private String descricao;
  private double peso;
  private String localPartida;
  private String localAtual;
  private String localDestino;
  private double preco;

  @ManyToOne(cascade = CascadeType.ALL)
  private User remetente;


  public Pedido() {}

  public Pedido(
      double peso,
      String descricao,
      String localPartida,
      String localAtual,
      String localDestino,
      double preco) {
    this.peso = peso;
    this.descricao = descricao;
    this.localPartida = localPartida;
    this.localAtual = localAtual;
    this.localDestino = localDestino;
    this.preco = preco;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double peso) {
    this.preco = peso*5;
  }

  public String getLocalPartida() {
    return localPartida;
  }

  public void setLocalPartida(String localPartida) {
    this.localPartida = localPartida;
  }

  public String getLocalDestino() {
    return localDestino;
  }

  public void setLocalDestino(String localDestino) {
    this.localDestino = localDestino;
  }

  public String getLocalAtual() {
    return localAtual;
  }

  public void setLocalAtual(String localAtual) {
    this.localAtual = localAtual;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public User getCliente() {
    return remetente;
  }

  public void setCliente(User remetente) {
    this.remetente = remetente;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }
}
