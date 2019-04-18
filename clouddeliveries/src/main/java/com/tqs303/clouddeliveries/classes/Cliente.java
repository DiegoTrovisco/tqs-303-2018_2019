/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqs303.clouddeliveries.classes;

/**
 *
 * @author Diego
 */
public class Cliente {
    
    private String nome;
    private int nr_cliente;
    private String endereco;
    private int telemovel;
    private int nif;

    public Cliente(String nome, int nr_cliente, String endereco, int telemovel, int nif) {
        this.nome = nome;
        this.nr_cliente = nr_cliente;
        this.endereco = endereco;
        this.telemovel = telemovel;
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public int getNr_cliente() {
        return nr_cliente;
    }

    public void setNr_cliente(int nr_cliente) {
        this.nr_cliente = nr_cliente;
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
    
    
    
}
