package com.peoplemanagement.people_management.repository;

import com.peoplemanagement.people_management.models.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    Person findPersonByIdPerson(Long idPerson);
    Optional<Person> findPersonByEmail(String email);
}
