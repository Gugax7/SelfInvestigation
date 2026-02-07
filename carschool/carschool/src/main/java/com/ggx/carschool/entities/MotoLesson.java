package com.ggx.carschool.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class MotoLesson extends Lesson {

    @ManyToOne
    private Motorcycle moto;

    public Motorcycle getMoto() {
        return moto;
    }

    public void setMoto(Motorcycle moto) {
        this.moto = moto;
    }
}
