package com.peoplemanagement.people_management.service.impl;

import com.peoplemanagement.people_management.exception.person.PersonNotFoundException;
import com.peoplemanagement.people_management.exception.person.PersonPresentException;
import com.peoplemanagement.people_management.models.dto.request.PersonRequest;
import com.peoplemanagement.people_management.models.dto.response.PersonResponse;
import com.peoplemanagement.people_management.models.entity.Person;
import com.peoplemanagement.people_management.models.mapper.PersonMapper;
import com.peoplemanagement.people_management.repository.PersonRepository;
import com.peoplemanagement.people_management.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    public final PersonMapper personMapper;

    public final PersonRepository personRepository;

    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public PersonResponse registerPerson(PersonRequest personRequest){
        existingEmail(personRequest.getEmail());
        Person person = personMapper.toPerson(personRequest);
        personRepository.save(person);
        return personMapper.toPersonResponse(person);
    }

    public void existingEmail(String email){
        personRepository.findPersonByEmail(email).ifPresent(people -> {
            throw new PersonPresentException();
        });
    }

    @Override
    public List<PersonResponse> getAllPeople(){
        List<Person> people = personRepository.findAll();
        return personMapper.toListPersonResponse(people);
    }

    @Override
    public PersonResponse getPersonById(Long idPerson){
        return personMapper.toPersonResponse(validatePerson(idPerson));
    }

    public Person validatePerson(Long idPerson){
        return personRepository.findById(idPerson).orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public PersonResponse updatePerson(Long idPerson, PersonRequest personRequest){
        existingEmail(personRequest.getEmail());
        Person person = validatePerson(idPerson);
        person.setName(personRequest.getName());
        person.setEmail(personRequest.getEmail());
        person.setBirthday(personRequest.getBirthday());
        return personMapper.toPersonResponse(personRepository.save(person));
    }

    @Override
    public String deletePerson(Long idPerson){
        Person person = validatePerson(idPerson);
        if(person != null){
            personRepository.delete(person);
            return "O usuário " + person.getName() + " foi removido com sucesso!";
        }
        return "O usuário com o id: " + idPerson + ", não encontrado! ";
    }
}
