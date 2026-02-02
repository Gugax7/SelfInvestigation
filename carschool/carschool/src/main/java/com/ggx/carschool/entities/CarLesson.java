package com.ggx.carschool.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CarLesson extends Lesson{

    @ManyToOne
    private Car car;
}
