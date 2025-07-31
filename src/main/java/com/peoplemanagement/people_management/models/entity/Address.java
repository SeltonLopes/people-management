package com.peoplemanagement.people_management.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;

@Data
@Entity(name = "tb_address")
public class Address {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    private String street;

    private String zipCode;

    private String number;

    private String city;

    private String state;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
}
