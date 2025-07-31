package com.peoplemanagement.people_management.exception.person;

import com.peoplemanagement.people_management.configuration.AlertException;
import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends AlertException {
    private static final String DEFAULT_MESSAGE = "Usuário não encontrado!";
    public PersonNotFoundException() {
        super("404", DEFAULT_MESSAGE, HttpStatus.NOT_FOUND);

    }
}
