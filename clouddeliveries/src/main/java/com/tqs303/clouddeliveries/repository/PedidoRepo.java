package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.Pedido;
import org.springframework.data.repository.Repository;

public interface PedidoRepo extends Repository<Pedido, Long> {

    Pedido findByIdPedido(int id_pedido);
    Pedido findByCliente(int cliente);
}
