package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByNome(String nome);
    User findByIdUser(int id);
}
