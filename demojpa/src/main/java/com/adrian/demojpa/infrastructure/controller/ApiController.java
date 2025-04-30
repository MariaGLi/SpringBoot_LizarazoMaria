package com.adrian.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.application.service.ProjectService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.domain.Rol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;

    private final ProjectService projectService;

    public ApiController(PersonService personService, ProjectService projectService) {
        this.projectService = projectService;
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

    @PostMapping
    public String newRole(){
        return "";
    }

    @GetMapping("/projects")
    public List<Project> findAllProjects(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value) {

        List<Project> results = projectService.findAllProjects();

        return results;
    }
}