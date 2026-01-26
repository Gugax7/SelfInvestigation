package com.ggx.carschool.entities;

import com.ggx.carschool.enums.VehicleType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    private Long id;
    private String name;
    private String password;

    @ElementCollection
    private List<VehicleType> authorizedVehicleType;
}
