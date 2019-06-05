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

@Component
@Controller
@RequestMapping(path = "/pedido")
public class PedidoControl {

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
      @RequestParam("peso") double peso,
      Model model) {

    user = this.uRepo.findByNome(principal.getName());

    this.pedido.setCliente(user);
    this.pedido.setDescricao(descricao);
    this.pedido.setLocalPartida(partida);
    this.pedido.setLocalAtual(partida);
    this.pedido.setLocalDestino(destino);
    this.pedido.setPeso(peso);
    this.pedido.setPreco(peso);

    this.pRepo.save(this.pedido);
    model.addAttribute("create", true);
    return "pedido";
  }

  @PostMapping(path = "/listar")
  public String findByUsername(@RequestParam("username") String user, Model model) {
    List<Pedido> result = pRepo.getAllByRemetente_Nome(user);
    if (result.isEmpty()) {
      model.addAttribute("error", true);
      return "listarpedidos";
    }
    model.addAttribute("result", result);
    return "listarpedidos";
  }

  @PostMapping(path = "/editar")
  public String findById(@RequestParam("idpedido") int id, Model model) {
    Pedido result = pRepo.findByIdPedido(id);
    if (result == null) {
      model.addAttribute("error", true);
      return "admineditar";
    }
    model.addAttribute("result", result);
    return "admineditar";
  }

  @PostMapping(path = "/atualizar")
  public String atualizarPedido(
      @RequestParam("idpedido") int id,
      @RequestParam("atual") String atual,
      @RequestParam("partida") String partida,
      @RequestParam("destino") String destino,
      @RequestParam("descricao") String descricao,
      @RequestParam("peso") double peso,
      Model model) {
    Pedido update = pRepo.findByIdPedido(id);
    if (update == null){
      model.addAttribute("error", true);
      return "adminpesquisa";
    }
    update.setLocalAtual(atual);
    update.setLocalDestino(destino);
    update.setLocalPartida(partida);
    update.setPeso(peso);
    update.setDescricao(descricao);
    pRepo.save(update);
    model.addAttribute("update", true);
    return "adminpesquisa";
  }
}
