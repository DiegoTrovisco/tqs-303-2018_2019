package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

  User findByNome(String nome);

  User findByIdUser(int id);
}
