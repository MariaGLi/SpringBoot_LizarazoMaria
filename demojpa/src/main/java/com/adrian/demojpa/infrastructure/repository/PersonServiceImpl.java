package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Passport;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.domain.dto.PersonRequest;
import com.adrian.demojpa.domain.dto.PersonResponse;
import com.adrian.demojpa.infrastructure.controller.Error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final DocumentRepository documentRepository;

    public PersonServiceImpl(RoleRepository roleRepository, PersonRepository personRepository, DocumentRepository documentRepository) {
        this.roleRepository = roleRepository;
        this.personRepository = personRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Person> findAllByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        } else if (filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public List<PersonResponse> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findAll().stream().map((person) -> {
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastName());
                response.setSkill(person.getLanguage());
                response.setPassport(person.getPassport() != null);
                return response;
            }).toList();
        } else if (filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findAll().stream().map((person) -> {
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastName());
                response.setSkill(person.getLanguage());
                response.setPassport(person.getPassport() != null);
                return response;
            }).toList();
        }
        return personRepository.findAll().stream().map((person) -> {
            PersonResponse response = new PersonResponse();
            response.setName(person.getName());
            response.setSurname(person.getLastName());
            response.setSkill(person.getLanguage());
            response.setPassport(person.getPassport() != null);
            return response;
        }).toList();
    }

    @Override
    public PersonResponse patchPerson(Long id, PersonRequest personDto) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el id " + id));

        if (personDto.getName() != null) {
            person.setName(personDto.getName());
        }
        if (personDto.getSurname() != null) {
            person.setLastName(personDto.getSurname());
        }
        if (personDto.getSkill() != null) {
            person.setLanguage(personDto.getSkill());
        }
        personRepository.save(person);

        PersonResponse response = new PersonResponse();
        response.setName(person.getName());
        response.setSurname(person.getLastName());
        response.setSkill(person.getLanguage());
        response.setPassport(person.getPassport() != null);
        return response;
    }

    @Override
    public PersonResponse createNewUser(PersonRequest personDto) {
        System.out.println("+++++++++++++++++++++++++++++");
        Optional<Person> person = personRepository.findPersonByPassportNumber(personDto.getPassport());

        //Validamos que el usuario no esté registrado
        //Si el usuario ya está registrado, lanzamos una excepción personalizada
        if (person.isPresent()) {
            throw new RolDuplicateException("El usuario ya se encuentra registrado", HttpStatus.CONFLICT);
        }

        //Buscamos el rol para el usuario
        //Si no existe el rol, lanzamos una excepción
        Rol userRol = roleRepository.findById(1L).orElseThrow(() ->  new EntityNotFoundException("No se encontró el rol"));

        //Creamos el usuario temporal
        Person newPerson = new Person();
        newPerson.setName(personDto.getName());
        newPerson.setLastName(personDto.getSurname()); 
        newPerson.setLanguage(personDto.getSkill());
        newPerson.setRole(userRol);

        //Guardamos el nuevo registro
        Person save = personRepository.save(newPerson);
        
        //Creamos el pasaporte temporal
        Passport newPassport = new Passport();
        newPassport.setPerson(save);
        newPassport.setNumber(personDto.getPassport());

        //Guardar el pasaporte o documento
        documentRepository.save(newPassport);

        //"Mapeo" de Person a PersonResponse
        save.setPassport(newPassport);

        PersonResponse response = new PersonResponse();
        response.setName(save.getName());
        response.setSurname(save.getLastName());
        response.setSkill(save.getLanguage());
        response.setPassport(save.getPassport() != null);

        return response;
    }
}
