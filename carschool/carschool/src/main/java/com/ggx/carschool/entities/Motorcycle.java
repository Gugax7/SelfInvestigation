package com.ggx.carschool.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Motorcycle extends Vehicle{
    private boolean hasSideCar;
}
