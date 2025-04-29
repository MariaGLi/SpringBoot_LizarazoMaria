package com.adrian.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;

    // @Qualifier("personServicePImpl")
    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/users")
    public List<Person> findAll(
            @RequestParam(name = "filter", defaultValue = "") String filter,
            @RequestParam(name = "value", defaultValue = "") String value) {

        List<Person> results = personService.findAllByFilter(filter, value);

        return results;
    }

    @GetMapping("/roles")
    public List<Rol> findAllRoles(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value) {

        List<Rol> results = personService.findAllRolesFilter(filter, value);

        return results;
    }
}