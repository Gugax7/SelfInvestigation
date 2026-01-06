package com.first.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.first.demo.domain.User;


@Service
public class userService {

  private final User user;

  public userService(User user){
    this.user = user;
  }

  public String tellAStory(){
    return "the user name is " + user.getName() + " and his age is " + user.getAge();
  }

  
}
