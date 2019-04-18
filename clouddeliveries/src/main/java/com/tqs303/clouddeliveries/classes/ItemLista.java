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
public class ItemLista {
    
    private int numero;
    private int quantidade;

    public ItemLista(int numero, int quantidade) {
        this.numero = numero;
        this.quantidade = quantidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
