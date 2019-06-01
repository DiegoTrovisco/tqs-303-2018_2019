package com.tqs303.clouddeliveries.RestAPI;

import com.tqs303.clouddeliveries.entities.AuthorityEnum;
import com.tqs303.clouddeliveries.entities.MyUserPrincipal;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping(path = "/rest/user")
public class APIUser {

  @Autowired private UserRepo uRepo;

  @Autowired private User user;

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @GetMapping(path = "/find/{nome}", produces = "application/json")
  public User findUser(@PathVariable("nome") String nome) {
    return uRepo.findByNome(nome);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public @ResponseBody Iterable<User> findAll() {
    return uRepo.findAll();
  }

  @GetMapping(path = "/create/admin/{name}", produces = "application/json")
  public User createAdmin(@PathVariable("name") String nome) {

    this.user.setPassword(passwordEncoder.encode("admin"));
    this.user.setNome(nome);
    this.user.setEndereco("");
    this.user.setTelemovel(0);
    this.user.setNif(0);
    this.user.setRole(AuthorityEnum.ROLE_ADMIN);
    this.uRepo.save(this.user);

    new MyUserPrincipal(this.user);

    return this.user;
  }
}
