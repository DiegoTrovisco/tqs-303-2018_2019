package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.Produto;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.ProdutoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


// TODO alterar createPedido
@Component
@RestController
@RequestMapping(path = "/pedido")
public class APIPedido {

    @Autowired
    private Pedido pedido;

    @Autowired
    private User user;

    @Autowired
    private Produto produto;

    @Autowired
    private PedidoRepo pRepo;

    @Autowired
    private UserRepo uRepo;

    @Autowired
    private ProdutoRepo produtoRepo;

    @PostMapping(path = "/criar_pedido")
    public void createPedido(Principal principal,
                             @RequestParam("descricao") String descricao,
                             @RequestParam("localPartida") String partida,
                             @RequestParam("localDestino") String destino,
                             @RequestParam("peso") double peso,
                             @RequestParam("tipo") String tipo,
                             @RequestParam("quantidade") int quantidade
                             ){

        user = this.uRepo.findByNome(principal.getName());
        this.pedido.setCliente(user);

        this.produto.setTipo(tipo);
        this.produto.setQuantidade(quantidade);
        this.produtoRepo.save(this.getProdutoClone(this.produto));

        List<Produto> query = this.produtoRepo.findAllByTipoAndQuantidade(tipo, quantidade);


        this.pedido.setDescricao(descricao);
        this.pedido.setLocalPartida(partida);
        this.pedido.setLocalAtual(partida);
        this.pedido.setLocalDestino(destino);
        this.pedido.setPeso(peso);
        this.pedido.setPreco(peso);
        this.pedido.setProdutos(query);
        this.pRepo.save(this.getPedidoClone(pedido));
    }

    @GetMapping(path = "/encontrarPedido")
    public void findPedido(@RequestParam("idPedido") int idPedido){
        this.pRepo.findByIdPedido(idPedido);
    }

    @GetMapping(path = "/pedidos", produces = "application/json")
    public @ResponseBody Iterable<Pedido> listarPedidos(){
        return this.pRepo.findAll();
    }

    @PostMapping(path = "/listar")
    public String findByUsername(@RequestParam("username") String user, Model model){

        List<Pedido> result = pRepo.getAllByRemetente_Nome(user);
        if (result == null){
            return "error";
        }
        model.addAllAttributes(result);
        return "listarpedidos";

    }

    private Pedido getPedidoClone(Pedido p){
        Pedido clone = new Pedido();
        clone.setCliente(p.getCliente());
        clone.setDescricao(p.getDescricao());
        clone.setLocalAtual(p.getLocalAtual());
        clone.setPeso(p.getPeso());
        return clone;
    }

    private Produto getProdutoClone(Produto pr){
        Produto clone = new Produto();
        clone.setTipo(pr.getTipo());
        clone.setQuantidade(pr.getQuantidade());
        return clone;
    }
}
