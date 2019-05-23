package com.tqs303.clouddeliveries;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  @GetMapping(path = "/login")
  public String login() {
    return "loginTest";
  }

  @GetMapping(path = "/")
  public String index(){
    return "indexTest";
  }
}
