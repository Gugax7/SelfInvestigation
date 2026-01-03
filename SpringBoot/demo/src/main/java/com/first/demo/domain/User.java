package com.first.demo.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Component
public class User {

  private String name;
  private int age;

  public String sayHello(){
    return "Hello from user!" + this.name;
  }
  
}
