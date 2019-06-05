package com.tqs303.clouddeliveries;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
class JPATest {

  @Autowired private UserRepo userRepo;

  @Autowired private PedidoRepo pedidoRepo;

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @BeforeEach
  void setup() {}

  @AfterEach
  void tearDown() {}

  @Test
  void criarUser() {
    User user = new User("nome", "password", "endereco", 962345698, 123456789);
    this.userRepo.save(user);

    User queryUser = userRepo.findByNome("nome");
    assertEquals(user.getIdUser(), queryUser.getIdUser());
    assertEquals(user.getNome(), queryUser.getNome());
    assertEquals(user.getPassword(), queryUser.getPassword());
    assertEquals(user.getEndereco(), queryUser.getEndereco());
    assertEquals(user.getTelemovel(), queryUser.getTelemovel());
    assertEquals(user.getIdUser(), queryUser.getIdUser());
  }

  @Test
  void criarPedido() {
    // First create user
    User user = new User("nome", "password", "endereco", 962345698, 123456789);
    this.userRepo.save(user);

    User queryUser = userRepo.findByNome("nome");
    assertEquals(user.getIdUser(), queryUser.getIdUser());
    assertEquals(user.getNome(), queryUser.getNome());
    assertEquals(user.getPassword(), queryUser.getPassword());
    assertEquals(user.getEndereco(), queryUser.getEndereco());
    assertEquals(user.getTelemovel(), queryUser.getTelemovel());
    assertEquals(user.getIdUser(), queryUser.getIdUser());

    // Create Request
    Pedido pedido = new Pedido();
    pedido.setCliente(queryUser);
    pedido.setDescricao("descr");
    pedido.setLocalPartida("partida");
    pedido.setLocalAtual(pedido.getLocalPartida());
    pedido.setLocalDestino("destino");

    pedidoRepo.save(pedido);

    assertEquals(1, pedidoRepo.getAllByRemetente_Nome("nome").size());
  }

  @Test
  void pedidoPorIdUser() {
    // First create user
    User user = new User("nome", "password", "endereco", 962345698, 123456789);
    this.userRepo.save(user);

    User queryUser = userRepo.findByIdUser(user.getIdUser());
    assertEquals(user.getIdUser(), queryUser.getIdUser());
    assertEquals(user.getNome(), queryUser.getNome());
    assertEquals(user.getPassword(), queryUser.getPassword());
    assertEquals(user.getEndereco(), queryUser.getEndereco());
    assertEquals(user.getTelemovel(), queryUser.getTelemovel());
    assertEquals(user.getIdUser(), queryUser.getIdUser());

    // Create Request
    Pedido pedido = new Pedido();
    pedido.setCliente(queryUser);
    pedido.setDescricao("descr");
    pedido.setLocalPartida("partida");
    pedido.setLocalAtual(pedido.getLocalPartida());
    pedido.setLocalDestino("destino");

    pedidoRepo.save(pedido);

    assertEquals(1, pedidoRepo.getAllByRemetente_IdUser(user.getIdUser()).size());
  }
}
