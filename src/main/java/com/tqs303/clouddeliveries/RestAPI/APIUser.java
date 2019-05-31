package com.tqs303.clouddeliveries.RestAPI;

import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping(path = "/rest/user")
public class APIUser {

    @Autowired private UserRepo uRepo;

    @GetMapping(path = "/find/{nome}", produces = "application/json")
    public User findUser(@PathVariable("nome") String nome) {
        return uRepo.findByNome(nome);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public @ResponseBody
    Iterable<User> findAll() {
        return uRepo.findAll();
    }
}
