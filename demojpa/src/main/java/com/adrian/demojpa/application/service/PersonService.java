package com.adrian.demojpa.application.service;

import java.util.List;

import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.dto.PersonRequest;

public interface PersonService {
    public List<Person> findAllByFilter(String filter, String value);
    public Person patchPerson(PersonRequest personDto, Long id);
}
