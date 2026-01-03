package com.first.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.demo.domain.User;

@RestController
public class HelloController {
  
  @GetMapping
  public String index(){
    return "Hello World!";
  }

  @PostMapping()
  public String postMethodName(@RequestBody User user) {
      return "Hello " + user.getName();
  }
  
}
