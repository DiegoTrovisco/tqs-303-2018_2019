package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.Principal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@AutoConfigureMockMvc
@WebMvcTest
class PedidoControlTest {

  @Autowired private WebApplicationContext webApplicationContext;

  @MockBean private PedidoRepo pedidoRepo;

  @MockBean private UserRepo userRepo;

  private MockMvc mockMvc;

  private Principal principal;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    principal = Mockito.mock(Principal.class);
    Mockito.when(principal.getName()).thenReturn("me");
  }

  @Test
  @WithMockUser()
  void createPedido() throws Exception {
    this.mockMvc
        .perform(get("/pedido"))
        .andDo(
            mvcResult ->
                this.mockMvc.perform(
                    post("/pedido/criar_pedido")
                        .param("descricao", "descricao")
                        .param("localPartida", "partida")
                        .param("localDestino", "destino")
                        .param("peso", "2")
                        .principal(this.principal)))
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser
  void findByUsername() throws Exception {
    this.mockMvc
        .perform(get("/pedido"))
        .andDo(
            mvcResult ->
                this.mockMvc
                    .perform(post("/pedido/listar").param("username", "tqs"))
                    .andExpect(status().is2xxSuccessful()))
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(roles = {"ADMIN"})
  void findById() throws Exception {
    this.mockMvc
        .perform(get("/pedido"))
        .andDo(
            mvcResult ->
                this.mockMvc
                    .perform(post("/pedido/editar").param("idpedido", "7"))
                    .andExpect(status().isOk()))
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(roles = {"ADMIN"})
  void atualizarPedido() throws Exception {
    this.mockMvc
        .perform(get("/pedido"))
        .andDo(
            mvcResult ->
                this.mockMvc
                    .perform(
                        post("/pedido/atualizar")
                            .param("idpedido", "2")
                            .param("atual", "atual")
                            .param("descricao", "descricao")
                            .param("partida", "partida")
                            .param("destino", "destino")
                            .param("peso", "2"))
                    .andExpect(status().isOk()))
        .andExpect(status().isOk());
  }
}
