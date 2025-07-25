package com.peoplemanagement.people_management.service;

import com.peoplemanagement.people_management.models.dto.request.PersonRequest;
import com.peoplemanagement.people_management.models.dto.response.PersonResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface PersonService {
    PersonResponse registerPerson(PersonRequest personRequest);

    List<PersonResponse> getAllPeople();

    PersonResponse getPersonById(Long id);

    PersonResponse updatePerson(Long id, PersonRequest personRequest);

    String deletePerson(Long id);
}
