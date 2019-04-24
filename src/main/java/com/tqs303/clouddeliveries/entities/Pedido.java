package com.tqs303.clouddeliveries.entities;


import javax.persistence.*;
import java.util.List;


/**
 * @author Diego
 */

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;

    private String descricao;
    private double peso;
    private String localAtual;
    private String destino;

    @ManyToOne(cascade = CascadeType.ALL)
    private User remetente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    public Pedido() {

    }

    public Pedido(double peso, String descricao, String localAtual, String destino) {
        this.peso = peso;
        this.descricao = descricao;
        this.localAtual = localAtual;
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
}
