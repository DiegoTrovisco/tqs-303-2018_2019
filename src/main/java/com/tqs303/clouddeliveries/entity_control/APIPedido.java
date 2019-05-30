package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

// TODO alterar createPedido
@Component
@Controller
@RequestMapping(path = "/pedido")
public class APIPedido {

  @Autowired private Pedido pedido;

  @Autowired private User user;

  @Autowired private PedidoRepo pRepo;

  @Autowired private UserRepo uRepo;

  @PostMapping(path = "/criar_pedido")
  public String createPedido(
      Principal principal,
      @RequestParam("descricao") String descricao,
      @RequestParam("localPartida") String partida,
      @RequestParam("localDestino") String destino,
      @RequestParam("peso") double peso) {

    user = this.uRepo.findByNome(principal.getName());
    this.pedido.setCliente(user);

    this.pedido.setDescricao(descricao);
    this.pedido.setLocalPartida(partida);
    this.pedido.setLocalAtual(partida);
    this.pedido.setLocalDestino(destino);
    this.pedido.setPeso(peso);

    this.pRepo.save(this.getPedidoClone(pedido));

    return "pedido";
  }

  @GetMapping(path = "/encontrarPedido")
  public void findPedido(@RequestParam("idPedido") int idPedido) {
    this.pRepo.findByIdPedido(idPedido);
  }

  @GetMapping(path = "/pedidos", produces = "application/json")
  public @ResponseBody Iterable<Pedido> listarPedidos() {
    return this.pRepo.findAll();
  }

  @PostMapping(path = "/listar")
  public String findByUsername(@RequestParam("username") String user, Model model) {
    User queryUser = this.uRepo.findByNome(user);
    List<Pedido> result = pRepo.getAllByRemetente_IdUser(queryUser.getIdUser());
    // List<Pedido> result = pRepo.getAllByRemetente_Nome(user);
    if (result == null) {
      return "error";
    }
    model.addAttribute("result", result);
    return "listarpedidos";
  }

  private Pedido getPedidoClone(Pedido p) {
    Pedido clone = new Pedido();
    clone.setCliente(p.getCliente());
    clone.setDescricao(p.getDescricao());
    clone.setLocalPartida(p.getLocalPartida());
    clone.setLocalDestino(p.getLocalDestino());
    clone.setPreco(p.getPeso());
    clone.setLocalAtual(p.getLocalAtual());
    clone.setPeso(p.getPeso());
    return clone;
  }
}
