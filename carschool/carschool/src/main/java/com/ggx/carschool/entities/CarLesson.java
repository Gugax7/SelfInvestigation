package com.ggx.carschool.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class CarLesson extends Lesson{

    @ManyToOne
    private Car car;
}
