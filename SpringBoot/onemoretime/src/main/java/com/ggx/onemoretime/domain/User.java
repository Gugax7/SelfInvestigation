package com.ggx.onemoretime.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Size(max = 20, message="Name is too long")
  @NotBlank
  private String name;
  @Min(value = 18, message = "User must be at least 18 yo")
  @Max(value = 130, message = "Wait, how are you are more than 130 years?")
  private int age;
  @Email
  private String email;
  
}
