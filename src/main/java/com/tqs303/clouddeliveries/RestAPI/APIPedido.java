package com.tqs303.clouddeliveries.RestAPI;

import com.tqs303.clouddeliveries.entities.Pedido;

import com.tqs303.clouddeliveries.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping(path = "/rest/pedido")
public class APIPedido {

    @Autowired private PedidoRepo pRepo;

    @GetMapping(path = "/find/{idPedido}")
    public void findPedido(@PathVariable("idPedido") int idPedido) {
        this.pRepo.findByIdPedido(idPedido);
    }

    @GetMapping(path = "/pedidos", produces = "application/json")
    public @ResponseBody
    Iterable<Pedido> listarPedidos() {
        return this.pRepo.findAll();
    }
}
