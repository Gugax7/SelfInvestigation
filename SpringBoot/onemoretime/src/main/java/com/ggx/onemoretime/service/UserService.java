package com.ggx.onemoretime.service;

import org.springframework.stereotype.Service;

import com.ggx.onemoretime.domain.User;

@Service
public class UserService {

  public void changeInfo(User user) throws Exception{
    if(user.getAge() < 60){
      user.setAge(sumAgeTen(user.getAge()));
    }
    else{
      throw new Exception("User cannot have more than 60 years to change the info");
    }

    if(user.getName().length() > 20){
      throw new Exception("This user name is too long");
    }
    else if(user.getName().length() == 0){
      throw new Exception("No name found!");
    }

    user.setName(addSecondName(user.getName()));

  }

  public int sumAgeTen(int age){
    return age+10;
  }

  public String addSecondName(String name){
    return name + " Boioiong";
  }
  
}
