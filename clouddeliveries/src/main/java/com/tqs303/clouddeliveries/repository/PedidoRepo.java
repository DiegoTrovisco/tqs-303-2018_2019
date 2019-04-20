package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PedidoRepo extends CrudRepository<Pedido, Long> {

    Pedido findByIdPedido(int id_pedido);
}
