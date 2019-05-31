package com.tqs303.clouddeliveries.entity_control;

import com.tqs303.clouddeliveries.entities.AuthorityEnum;
import com.tqs303.clouddeliveries.entities.MyUserPrincipal;
import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.PedidoRepo;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping(path = "/user")
public class UserControl {

  @Autowired private User user;

  @Autowired private Pedido pedido;

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @Autowired private UserRepo uRepo;

  @Autowired private PedidoRepo pRepo;

  @PostMapping(path = "/registar")
  public void createUser(
      @RequestParam("name") String nome,
      @RequestParam("psw") String password,
      @RequestParam("email") String endereco,
      @RequestParam("phone") int telemovel,
      @RequestParam("nif") int nif) {
    this.user.setPassword(password);
    this.user.setNome(nome);
    this.user.setEndereco(endereco);
    this.user.setTelemovel(telemovel);
    this.user.setNif(nif);
    this.user.setRole(AuthorityEnum.ROLE_USER);
    this.uRepo.save(this.getUserClone(user));

    new MyUserPrincipal(this.user);
  }

  private User getUserClone(User u) {
    User clone = new User();
    clone.setPassword(passwordEncoder.encode(u.getPassword()));
    clone.setNome(u.getNome());
    clone.setEndereco(u.getEndereco());
    clone.setTelemovel(u.getTelemovel());
    clone.setRole(u.getRole());
    clone.setNif(u.getNif());
    return clone;
  }
}
