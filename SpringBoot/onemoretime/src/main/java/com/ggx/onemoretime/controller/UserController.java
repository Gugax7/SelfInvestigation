package com.ggx.onemoretime.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.ggx.onemoretime.domain.User;
import com.ggx.onemoretime.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("/user")
  public String getMethodName(User user) {
    return user.getName() +" "+ user.getAge();
  }

  @PostMapping("/user")
  public User postMethodName(@RequestBody User user) {
    return user;
  }
  
  @PutMapping("/user")
  public String changeInfo(@RequestBody User user) throws Exception {
    service.changeInfo(user);
    return user.toString();
  }
  
  
}
