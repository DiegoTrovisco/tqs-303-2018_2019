package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.AuthorityEnum;
import com.tqs303.clouddeliveries.entities.MyUserPrincipal;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Component
@Controller
@RequestMapping(path = "/user")
public class UserControl {

  @Autowired private User user;

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @Autowired private UserRepo uRepo;

  @PostMapping(path = "/registar")
  public String createUser(
      @RequestParam("name") String nome,
      @RequestParam("psw") String password,
      @RequestParam("email") String endereco,
      @RequestParam("phone") int telemovel,
      @RequestParam("nif") int nif,
      Model model) {
    if(this.user == null){
      model.addAttribute("error", true);
      return "register";
    }
    this.user.setNome(nome);
    this.user.setPassword(passwordEncoder.encode(password));
    this.user.setEndereco(endereco);
    this.user.setTelemovel(telemovel);
    this.user.setNif(nif);
    this.user.setRole(AuthorityEnum.ROLE_USER);
    this.uRepo.save(this.user);

    new MyUserPrincipal(this.user);
    model.addAttribute("create", true);
    return "register";
  }

  @GetMapping(path = "/info")
  public String infoUser(Principal principal, Model model) {
    User query = uRepo.findByNome(principal.getName());
    if (query == null) {
      model.addAttribute("error", true);
      return "updateuser";
    }
    model.addAttribute("user", query);
    return "updateuser";
  }

  @PostMapping(path = "/update")
  public String updateUser(
      @RequestParam("name") String nome,
      @RequestParam("psw") String password,
      @RequestParam("email") String endereco,
      @RequestParam("phone") int telemovel,
      @RequestParam("nif") int nif,
      Model model,
      Principal principal) {
    this.user = uRepo.findByNome(principal.getName());
    if (this.user == null) {
      model.addAttribute("error", true);
      return "updateuser";
    }
    this.user.setPassword(passwordEncoder.encode(password));
    this.user.setNome(nome);
    this.user.setEndereco(endereco);
    this.user.setTelemovel(telemovel);
    this.user.setNif(nif);
    this.uRepo.save(user);
    model.addAttribute("update", true);
    model.addAttribute("user", this.user);

    new MyUserPrincipal(this.user);
    return "updateuser";
  }
}
