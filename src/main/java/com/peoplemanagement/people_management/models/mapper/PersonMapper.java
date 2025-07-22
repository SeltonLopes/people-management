package com.peoplemanagement.people_management.models.mapper;

import com.peoplemanagement.people_management.models.dto.request.PersonRequest;
import com.peoplemanagement.people_management.models.dto.response.PersonResponse;
import com.peoplemanagement.people_management.models.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toPerson(PersonRequest personRequest);

    PersonResponse toPersonResponse(Person person);
}
