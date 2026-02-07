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

    public LocalDate getLastReview() {
        return lastReview;
    }

    public void setLastReview(LocalDate lastReview) {
        this.lastReview = lastReview;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}
