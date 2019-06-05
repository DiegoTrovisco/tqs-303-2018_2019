package com.tqs303.clouddeliveries;

import com.tqs303.clouddeliveries.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClouddeliveriesApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClouddeliveriesApplication.class, args);
  }

  @Bean(name = "passinstace")
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean(name = "userinstance")
  public User userInstance() {
    return new User();
  }

  @Bean(name = "pedidoinstance")
  public Pedido pedidoInstance() {
    return new Pedido();
  }
}
