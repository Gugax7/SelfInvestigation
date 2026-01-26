package com.ggx.carschool.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Lesson {
    @Id
    private Long id;
    private LocalDateTime startTime;

    @ManyToOne
    private User student;
    @ManyToOne
    private User instructor;

}
