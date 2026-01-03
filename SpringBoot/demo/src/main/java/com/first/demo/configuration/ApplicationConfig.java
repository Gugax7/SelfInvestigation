package com.first.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.first.demo.domain.User;

@Configuration
public class ApplicationConfig {

  @Bean
  public User user(){
    return new User("Rafael", 21);
  }

  @Bean
  @Qualifier("secondOne")
  public User userTwo(){
    return new User("Miguel", 23);
  }
  
}
