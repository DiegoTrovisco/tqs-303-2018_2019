package com.tqs303.clouddeliveries;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Nested
@SpringBootTest
@AutoConfigureMockMvc
class ViewControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void login() throws Exception {
    this.mockMvc
        .perform(formLogin().user("tqs").password("tqs"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/"));
  }

  @Test
  void loginError() throws Exception {
    this.mockMvc
        .perform(formLogin().user("nope").password("nope"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/login?error"));
  }

  @Test
  void loginGet() throws Exception {
    this.mockMvc
            .perform(get("/login"))
            .andExpect(status().isOk());
  }

  @Test
  void index() throws Exception {
    this.mockMvc.perform(get("/")).andExpect(status().isOk());
  }

  @Test
  void information() throws Exception {
    this.mockMvc.perform(get("/information")).andExpect(status().isOk());
  }

  @Test
  void register() throws Exception {
    this.mockMvc.perform(get("/register")).andExpect(status().isOk());
  }

  @Test
  @WithMockUser
  void pedidoOK() throws Exception {
    this.mockMvc.perform(get("/pedido")).andExpect(status().isOk());
  }

  @Test
  void pedidoFail() throws Exception {
    this.mockMvc.perform(get("/pedido")).andExpect(status().is3xxRedirection());
  }

  @Test
  @WithMockUser
  void verpedidosOK() throws Exception {
    this.mockMvc.perform(get("/verpedidos")).andExpect(status().isOk());
  }

  @Test
  void verpedidosFail() throws Exception {
    this.mockMvc.perform(get("/verpedidos")).andExpect(status().is3xxRedirection());
  }

  @Test
  @WithMockUser(roles = {"ADMIN"})
  void actualizarpedidos() throws Exception {
    this.mockMvc.perform(get("/actualizarpedidos")).andExpect(status().isOk());
  }

  @Test
  void actualizarpedidosFail() throws Exception {
    this.mockMvc.perform(get("/actualizarpedidos")).andExpect(status().is3xxRedirection());
  }
}
