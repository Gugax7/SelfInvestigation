package com.ggx.onemoretime.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ggx.onemoretime.domain.User;
import com.ggx.onemoretime.repository.UserRepository;

@ExtendWith(Mockito.class)
public class UserServiceTest {

  @Mock
  private UserRepository repository;

  @InjectMocks
  private UserService service;

  @Test
  public boolean testCreateUser() {
    User inputUser = new User();

  }
  
}
