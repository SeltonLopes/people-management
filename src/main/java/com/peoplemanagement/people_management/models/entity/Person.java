package com.peoplemanagement.people_management.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDate;

@Data
@Entity(name = "tb_person")
public class Person {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 80)
    @NotBlank
    private String name;

    @Size(min = 2, max = 80)
    @NotBlank
    private String email;

    @Past
    private LocalDate birthday;

}
