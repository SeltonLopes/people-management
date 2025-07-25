package com.peoplemanagement.people_management.controller;

import com.peoplemanagement.people_management.models.dto.request.PersonRequest;
import com.peoplemanagement.people_management.models.dto.response.PersonResponse;
import com.peoplemanagement.people_management.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
@Service
public class PersonController {

    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/registerPerson")
    public ResponseEntity<PersonResponse> registerPerson(@RequestBody @Valid PersonRequest personRequest) {
       return ResponseEntity.status(HttpStatus.CREATED).body(personService.registerPerson(personRequest));
    }

    @GetMapping("/people")
    public ResponseEntity<List<PersonResponse>> getAllPeople(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPeople());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long id,
                                                       @RequestBody @Valid PersonRequest personRequest){
        return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(id, personRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(id));
    }
}
