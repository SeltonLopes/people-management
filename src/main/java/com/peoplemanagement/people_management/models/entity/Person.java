package com.peoplemanagement.people_management.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "tb_person")
public class Person {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    @Size(min = 2, max = 80)
    @NotBlank
    private String name;

    @Size(min = 2, max = 80)
    @NotBlank
    private String email;

    @Past
    private LocalDate birthday;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

}
