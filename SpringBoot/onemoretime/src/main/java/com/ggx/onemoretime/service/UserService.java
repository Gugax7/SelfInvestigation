package com.ggx.onemoretime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ggx.onemoretime.domain.User;
import com.ggx.onemoretime.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public List<User> listAllUsers() {
    return repository.findAll();
  }

  public User addUser(User user){
    return repository.save(user);
  }

  public User changeInfo(User user){
    return repository.save(user);
  }
  
}
