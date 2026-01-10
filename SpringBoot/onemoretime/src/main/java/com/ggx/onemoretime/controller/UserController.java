package com.ggx.onemoretime.controller;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ggx.onemoretime.domain.User;
import com.ggx.onemoretime.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> listAllUsers() {
    return new ResponseEntity<>(service.listAllUsers(), HttpStatus.OK);
  }

  @PostMapping("/user")
  public ResponseEntity<User> postMethodName(@RequestBody @Valid User user) {
    User savedUser = service.addUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }
  
  @PutMapping("/user/{id}")
  public String changeInfo(@RequestBody User user, @PathVariable Long id) {
    user.setId(id);

    service.changeInfo(user);
    return user.toString();
  }
  
  
}
