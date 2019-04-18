package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class APIPedido {

    @Autowired
    private Pedido pedido;

    @PostMapping(path = "/criar_pedido")
    public void createPedido(){
        // TODO: implemetar
    }

    @GetMapping(path = "encontrar_pedido")
    public void findPedido(@RequestParam("idPedido") int idPedido){
        // TODO: implementar
    }
}
