package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Transient;
import java.util.List;

@Component
@RestController
@RequestMapping(path = "/user")
public class APIUser {

  @Autowired private User user;

  @Autowired private Pedido pedido;

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @Autowired private UserRepo uRepo;

  @Autowired private PedidoRepo pRepo;

  @PostMapping(path = "/criar_user", consumes = "application/json")
  public void createUser(
      @RequestParam("nome") String nome,
      @RequestParam("password") String password,
      @RequestParam("endereco") String endereco,
      @RequestParam("telemovel") int telemovel,
      @RequestParam("nif") int nif) {
    this.user.setPassword(password);
    this.user.setNome(nome);
    this.user.setEndereco(endereco);
    this.user.setTelemovel(telemovel);
    this.user.setNif(nif);
    uRepo.save(this.getUserClone(user));
  }

  @GetMapping(path = "/encontrarUser", produces = "application/json")
  public User findUser(@RequestParam("nome") String nome) {
    return uRepo.findByNome(nome);
  }

  @GetMapping(path = "/users", produces = "application/json")
  public @ResponseBody Iterable<User> findAll() {
    return uRepo.findAll();
  }

  private User getUserClone(User u) {
    User clone = new User();
    clone.setPassword(passwordEncoder.encode(u.getPassword()));
    clone.setNome(u.getNome());
    clone.setEndereco(u.getEndereco());
    clone.setTelemovel(u.getTelemovel());
    clone.setNif(u.getNif());
    return clone;
  }
  // TODO query for user pass -> create in memory user -> login

}
