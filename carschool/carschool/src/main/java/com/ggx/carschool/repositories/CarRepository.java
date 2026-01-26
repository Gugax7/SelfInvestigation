package com.ggx.carschool.repositories;

import com.ggx.carschool.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
