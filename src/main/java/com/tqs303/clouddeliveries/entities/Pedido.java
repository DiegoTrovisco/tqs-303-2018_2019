package com.tqs303.clouddeliveries.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.MERGE)
  private User remetente;

  public Pedido() {}

  public double getPreco() {
    return preco;
  }

  public void setPreco(double peso) {
    this.preco = peso * 5;
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
}
