package com.tqs303.clouddeliveries;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.Produto;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.ProdutoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class JPATest {

  @Autowired private ProdutoRepo produtoRepo;

  @Autowired private UserRepo userRepo;

  @Autowired private PedidoRepo pedidoRepo;

  @BeforeEach
  void setup() {}

  @AfterEach
  void tearDown() {}

  @Test
  void criarPedido() {
    Produto produto = new Produto("test", 100);
    produtoRepo.save(produto);

    assertEquals(produtoRepo.findAllByTipo("test").size(), 1);
    //Pedido
  }
}
