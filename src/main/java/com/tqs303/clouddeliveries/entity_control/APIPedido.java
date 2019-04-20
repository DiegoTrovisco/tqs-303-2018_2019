package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
@RequestMapping(path = "/pedido")
public class APIPedido {

    @Autowired
    private Pedido pedido;

    @Autowired
    private PedidoRepo pRepo;

//    @PostMapping(path = "/criar_pedido", consumes = "application/json")
//    public void createPedido(@RequestParam("cliente") User cliente,
//                             @RequestParam("descricao") String descricao,
//                             @RequestParam("aLocal") String aLocal,
//                             @RequestParam("pesp") double peso
//                             ){
//        this.pedido.setCliente(cliente);
//        this.pedido.setDescricao(descricao);
//        this.pedido.setLocalAtual(aLocal);
//        this.pedido.setPeso(peso);
//        this.getPedidoClone( this.getPedidoClone(pedido));
//    }

    @GetMapping(path = "/encontrarPedido")
    public void findPedido(@RequestParam("idPedido") int idPedido){
        this.pRepo.findByIdPedido(idPedido);
    }

    @GetMapping(path = "/pedidos", produces = "application/json")
    public @ResponseBody Iterable<Pedido> listarPedidos(){
        return this.pRepo.findAll();
    }

    private Pedido getPedidoClone(Pedido p){
        Pedido clone = new Pedido();
        clone.setCliente(p.getCliente());
        clone.setDescricao(p.getDescricao());
        clone.setLocalAtual(p.getLocalAtual());
        clone.setPeso(p.getPeso());
        return clone;
    }
}
