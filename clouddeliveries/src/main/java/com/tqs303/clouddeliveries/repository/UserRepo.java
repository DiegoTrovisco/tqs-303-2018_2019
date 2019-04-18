package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.User;
import org.springframework.data.repository.Repository;

public interface UserRepo extends Repository<User, Long> {

    User findByNome(String nome);
}
