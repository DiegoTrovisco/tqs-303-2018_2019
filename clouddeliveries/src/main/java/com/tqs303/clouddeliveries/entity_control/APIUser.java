package com.tqs303.clouddeliveries.entity_control;


import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class APIUser {

    @Autowired
    private User user;

    @Autowired
    private UserRepo uRepo;

    @PostMapping(path = "/criar_user", consumes = "application/json")
    public User createUser(@RequestParam("nome") String nome,
                            @RequestParam("password") String password,
                            @RequestParam("endereco") String endereco,
                            @RequestParam("telemovel") int telemovel,
                            @RequestParam("nif") int nif ){
        user = new User(nome, password, endereco, telemovel, nif);
        return user;
    }

    @GetMapping(path = "/encontrar_user", produces = "application/json")
    public User findUser(@RequestParam("nome") String nome){
        return uRepo.findByNome(nome);
    }
}