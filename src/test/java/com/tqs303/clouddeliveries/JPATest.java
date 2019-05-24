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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Nested
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
class JPATest {

  @Autowired private ProdutoRepo produtoRepo;

  @Autowired private UserRepo userRepo;

  @Autowired private PedidoRepo pedidoRepo;

  private List<Produto> produtoList;

  @BeforeEach
  void setup() {
    produtoList = new ArrayList<>();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void criarPedido() {
    // First create user
    User user = new User("nome", "password", "endereco", 962345698, 123456789);
    userRepo.save(user);

    User queryUser = userRepo.findByNome("nome");
    assertEquals(user.getIdUser(), queryUser.getIdUser());
    assertEquals(user.getNome(), queryUser.getNome());
    assertEquals(user.getPassword(), queryUser.getPassword());
    assertEquals(user.getEndereco(), queryUser.getEndereco());
    assertEquals(user.getTelemovel(), queryUser.getTelemovel());
    assertEquals(user.getIdUser(), queryUser.getIdUser());

    // Second create produto
    Produto produto = new Produto("test", 100);
    produtoRepo.save(produto);

    Produto queryProduto = produtoRepo.findByTipoAndQuantidade("test", 100);
    assertEquals(1, produtoRepo.findAllByTipo("test").size());
    assertEquals(produto.getTipo(), queryProduto.getTipo());
    assertEquals(produto.getQuantidade(), queryProduto.getQuantidade());
    assertEquals(produto.getIdProduto(), queryProduto.getIdProduto());


    // Create Request
    Pedido pedido = new Pedido();
    pedido.setCliente(queryUser);
    pedido.setDescricao("descr");
    pedido.setLocalPartida("partida");
    produtoList.add(queryProduto);
    pedido.setProdutos(produtoList);
    pedido.setLocalAtual(pedido.getLocalPartida());
    pedido.setLocalDestino("destino");

    pedidoRepo.save(pedido);

    assertEquals(1, pedidoRepo.getAllByRemetente_Nome("nome").size());
  }
}
