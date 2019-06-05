package com.tqs303.clouddeliveries.RestAPI;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@SpringBootTest
@AutoConfigureMockMvc
class APIPedidoTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private UserRepo userRepo;

  @Autowired private PedidoRepo pedidoRepo;

  private User user;
  private Pedido pedido;

  private int pid;

  @BeforeEach
  void setup() {

    user = new User("nome", "password", "endereco", 962345698, 987654321);
    userRepo.save(user);

    pedido = new Pedido();
    pedido.setCliente(user);
    pedido.setDescricao("descr");
    pedido.setLocalPartida("partida");
    pedido.setLocalAtual(pedido.getLocalPartida());
    pedido.setLocalDestino("destino");

    pedidoRepo.save(pedido);

    List<Pedido> query = pedidoRepo.getAllByRemetente_Nome("nome");

    pid = query.get(0).getIdPedido();
  }

  @AfterEach
  void destroy() {
    pedidoRepo.delete(pedido);
    userRepo.delete(user);
  }

  @Test
  void findPedido() throws Exception {
    this.mockMvc
        .perform(get("/rest/pedido/find/{idpedido}", this.pid))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  void listarPedidos() throws Exception {
    this.mockMvc
        .perform(get("/rest/pedido/all"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  void findByUsername() throws Exception {
    this.mockMvc
        .perform(get("/rest/pedido/byUser/nome"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }
}
