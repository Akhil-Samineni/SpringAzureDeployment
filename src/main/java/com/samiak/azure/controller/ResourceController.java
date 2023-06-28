package com.samiak.azure.controller;

import com.samiak.azure.model.Person;
import com.samiak.azure.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/api/hello")
    public String hello() {
        return "API hello";
    }

    @GetMapping("/api/mongo/persons")
    public List<Person> getPersons() {
        List<Person> people = personRepository.findAll();
        return people;
    }

}
