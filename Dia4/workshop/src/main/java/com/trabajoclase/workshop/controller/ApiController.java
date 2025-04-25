package com.trabajoclase.workshop.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajoclase.workshop.domain.Person;
import com.trabajoclase.workshop.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    // /api/usuers

    private final PersonRepository personRepository;

    public ApiController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/users")
    public List<Person> findAll() {
        //List<Person> results = personRepository.findByNameContains("a");
        List<Person> results = personRepository.findByProgrammingLanguageEquals("Java");

        return results;
    }
}

// /api/listar
// /api/buscar
