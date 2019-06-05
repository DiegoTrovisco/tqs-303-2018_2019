package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@AutoConfigureMockMvc
@WebMvcTest
class UserControlTest {

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
  void createUser() throws Exception {
    this.mockMvc
        .perform(
            post("/user/registar")
                .param("name", "nome")
                .param("psw", "pass")
                .param("email", "email")
                .param("phone", "123")
                .param("nif", "999999999"))
        .andExpect(status().isOk());
  }

  @Test
  void infoUser() throws Exception {
    this.mockMvc.perform(get("/user/info").principal(principal)).andExpect(status().isOk());
  }

  @Test
  void updateUser() throws Exception {
    this.mockMvc
        .perform(
            post("/user/update")
                .param("name", "nome")
                .param("psw", "pass")
                .param("email", "email")
                .param("phone", "123")
                .param("nif", "999999999")
                .principal(principal))
        .andExpect(status().isOk());
  }
}
