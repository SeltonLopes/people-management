package com.peoplemanagement.people_management.exception.person;

import com.peoplemanagement.people_management.configuration.AlertException;
import org.springframework.http.HttpStatus;

public class PersonPresentException extends AlertException {

    private static final String DEFAULT_MESSAGE = "Email já cadastrado";

    public PersonPresentException(){
        super("409", DEFAULT_MESSAGE, HttpStatus.CONFLICT);
    }
}
