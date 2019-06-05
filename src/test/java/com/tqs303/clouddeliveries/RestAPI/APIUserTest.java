package com.tqs303.clouddeliveries.RestAPI;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@SpringBootTest
@AutoConfigureMockMvc
class APIUserTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private UserRepo userRepo;

  private User user;

  @BeforeEach
  void setup() {
    user = new User("nome", "password", "endereco", 962345698, 999999999);
    userRepo.save(user);
  }

  @AfterEach
  void destroy() {
    userRepo.delete(user);
  }

  @Test
  void findUser() throws Exception {
    this.mockMvc
        .perform(get("/rest/user/find/{name}", "nome"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  void findAll() throws Exception {
    this.mockMvc
        .perform(get("/rest/user/all"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  void createAdmin() throws Exception {
    this.mockMvc
        .perform(get("/rest/user/create/admin/{admin}", "mockadmin"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
    // Then delete
    User remove = this.userRepo.findByNome("mockadmin");
    this.userRepo.delete(remove);
  }
}
