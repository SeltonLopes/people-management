package com.peoplemanagement.people_management.repository;

import com.peoplemanagement.people_management.models.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    Person findPersonById(Long id);
}
