/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqs303.clouddeliveries.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class Pedido {
    
    private int id_cliente;
    private int numero;
    List<String> compras;

    public Pedido(int id_cliente, int numero, List<String> compras) {
        this.id_cliente = id_cliente;
        this.numero = numero;
        this.compras =  new ArrayList<String>();
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<String> getCompras() {
        return compras;
    }

    public void setCompras(List<String> compras) {
        this.compras = compras;
    }

    
    
    
    
    
}
