package com.peoplemanagement.people_management.service.impl;

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
        Person person = personMapper.toPerson(personRequest);
        personRepository.save(person);
        return personMapper.toPersonResponse(person);
    }

//    public String existingEmail(String email){
//        Optional<Person> person = personRepository.findPersonByEmail(email);
//        if (person.isPresent()){
//            return "Email ja existente!";
//        }
//        return "ok";
//    }

    @Override
    public List<PersonResponse> getAllPeople(){
        List<Person> people = personRepository.findAll();
        return personMapper.toListPersonResponse(people);
    }

    @Override
    public PersonResponse getPersonById(Long id){
        return personMapper.toPersonResponse(validatePerson(id));
    }

    public Person validatePerson(Long id){
        return personRepository.findPersonById(id);
    }

    @Override
    public PersonResponse updatePerson(Long id, PersonRequest personRequest){
        Person person = validatePerson(id);
        person.setName(personRequest.getName());
        person.setEmail(personRequest.getEmail());
        person.setBirthday(personRequest.getBirthday());
        return personMapper.toPersonResponse(personRepository.save(person));
    }

    @Override
    public String deletePerson(Long id){
        Person person = personRepository.findPersonById(id);
        if(person != null){
            personRepository.delete(person);
            return "O usuário " + person.getName() + " foi removido com sucesso!";
        }
        return "O usuário com o id: " + id + ", não encontrado! ";
    }
}
