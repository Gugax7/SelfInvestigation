package com.ggx.onemoretime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggx.onemoretime.domain.User;

public interface UserRepository  extends JpaRepository<User,Long> {
  
}
