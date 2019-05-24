package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PedidoRepo extends CrudRepository<Pedido, Long> {

    Pedido findByIdPedido(int id_pedido);
    List<Pedido> getAllByRemetente_IdUser(int id);
    List<Pedido> getAllByRemetente_Nome(String nome);
}
