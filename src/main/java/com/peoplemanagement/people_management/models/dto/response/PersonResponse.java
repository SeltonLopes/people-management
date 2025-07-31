package com.peoplemanagement.people_management.models.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonResponse {

    private Long idPerson;
    private String name;
    private String email;
    private LocalDate birthday;
}
