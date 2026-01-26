package com.ggx.carschool.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class MotoLesson extends Lesson {

    @ManyToOne
    private Motorcycle moto;

}
