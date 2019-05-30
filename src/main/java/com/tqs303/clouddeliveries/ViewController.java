package com.tqs303.clouddeliveries;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

  @GetMapping(path = "/login")
  public String login() {
    return "login";
  }

  @GetMapping(path = "/")
  public String index() {
    return "index";
  }

  @GetMapping(path = "/information")
  public String information() {
    return "information";
  }

  @GetMapping(path = "/register")
  public String register() {
    return "register";
  }

  @GetMapping(path = "/pedido")
  public String pedido() {
    return "pedido";
  }

  @GetMapping(path = "/verpedidos")
  public String verpedidos() {
    return "verpedidos";
  }

}
