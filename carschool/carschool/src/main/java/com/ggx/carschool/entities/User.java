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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<VehicleType> getAuthorizedVehicleType() {
        return authorizedVehicleType;
    }

    public void setAuthorizedVehicleType(List<VehicleType> authorizedVehicleType) {
        this.authorizedVehicleType = authorizedVehicleType;
    }
}
