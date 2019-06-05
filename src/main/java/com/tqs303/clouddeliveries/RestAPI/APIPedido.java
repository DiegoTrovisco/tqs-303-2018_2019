package com.tqs303.clouddeliveries.RestAPI;

import com.tqs303.clouddeliveries.entities.Pedido;

import com.tqs303.clouddeliveries.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(path = "/rest/pedido")
public class APIPedido {

  @Autowired private PedidoRepo pRepo;

  @GetMapping(path = "/find/{idPedido}", produces = "application/json")
  public Pedido findPedido(@PathVariable("idPedido") int idPedido) {
    return this.pRepo.findPedidoByIdPedido(idPedido);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public @ResponseBody Iterable<Pedido> listarPedidos() {
    return this.pRepo.findAll();
  }

  @GetMapping(path = "/byUser/{username}", produces = "application/json")
  public @ResponseBody List findByUsername(@PathVariable("username") String user) {
    return this.pRepo.getAllByRemetente_Nome(user);
  }
}
