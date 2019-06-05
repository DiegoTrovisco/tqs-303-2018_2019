/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqs303.clouddeliveries.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idUser;

  private String nome;
  private String endereco;
  private int telemovel;

  @Column(unique = true)
  private int nif;

  @JsonIgnore
  @OneToMany(mappedBy = "remetente", cascade = CascadeType.MERGE)
  private List<Pedido> pedidos;

  @JsonIgnore private String password;

  private AuthorityEnum role;

  public User() {}

  public User(String nome, String password, String endereco, int telemovel, int nif) {
    this.nome = nome;
    this.password = password;
    this.endereco = endereco;
    this.telemovel = telemovel;
    this.nif = nif;
    this.role = AuthorityEnum.ROLE_USER;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public int getTelemovel() {
    return telemovel;
  }

  public void setTelemovel(int telemovel) {
    this.telemovel = telemovel;
  }

  public int getNif() {
    return nif;
  }

  public void setNif(int nif) {
    this.nif = nif;
  }

  public String getPassword() {
    return password;
  }

  public AuthorityEnum getRole() {
    return role;
  }

  public void setRole(AuthorityEnum role) {
    this.role = role;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public int getIdUser() {
    return idUser;
  }
}
