package com.ggx.carschool.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Car extends Vehicle {
    private LocalDate lastReview;
    private String model;
    private String transmissionType;

}
