package com.peoplemanagement.people_management.service;

import com.peoplemanagement.people_management.models.dto.request.PersonRequest;
import com.peoplemanagement.people_management.models.dto.response.PersonResponse;

public interface PersonService {
    PersonResponse registerPerson(PersonRequest personRequest);
}
