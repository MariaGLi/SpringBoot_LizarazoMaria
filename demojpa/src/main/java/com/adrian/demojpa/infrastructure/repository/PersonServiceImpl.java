package com.adrian.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.dto.PersonRequest;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllByFilter(String filter, String value) {
        if(filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        } else if(filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public Person patchPerson(PersonRequest personDto, Long id) {
        Person person = personRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontró el id " + id));

        if(personDto.getName() != null) {
            person.setName(personDto.getName());
        }
        if(personDto.getSurname() != null) {
            person.setLanguage(personDto.getSurname());
        }
        if(personDto.getSkill() != null) {
            person.setLanguage(personDto.getSkill());
        }
        personRepository.save(person);
        return person;
    }
}
