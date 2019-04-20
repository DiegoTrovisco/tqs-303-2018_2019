package com.tqs303.clouddeliveries.entities;



import javax.persistence.*;


/**
 *
 * @author Diego
 */

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;

//    private int cliente;
    private String descricao;
    private double peso;
    private String localAtual;

    // (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "remetente")
    private User remetente;

    public Pedido(){

    }

    public Pedido(double peso , String descricao, String localAtual) {
        this.peso = peso;
        this.descricao = descricao;
        this.localAtual = localAtual;
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
