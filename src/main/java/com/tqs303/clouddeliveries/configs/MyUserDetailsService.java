package com.tqs303.clouddeliveries.configs;

import com.tqs303.clouddeliveries.entities.MyUserPrincipal;
import com.tqs303.clouddeliveries.entities.User;
import com.tqs303.clouddeliveries.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired private UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = userRepo.findByNome(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return new MyUserPrincipal(user);
  }

}
