package com.adrian.demojpa.application.service;

import java.util.List;

import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.dto.PersonRequest;
import com.adrian.demojpa.domain.dto.PersonResponse;

public interface PersonService {
    public List<Person> findAllByFilter(String filter, String value);
    public PersonResponse patchPerson(Long id, PersonRequest personDto);
    public List<PersonResponse> findAllUsersByFilter(String filter, String value);
    public PersonResponse createNewUser(PersonRequest personDto);
}
