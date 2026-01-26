package com.ggx.carschool.repositories;

import com.ggx.carschool.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
