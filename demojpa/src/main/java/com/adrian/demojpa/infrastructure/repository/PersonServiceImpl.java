package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.infrastructure.controller.Error.RolDuplicateException;

@Service
public class PersonServiceImpl implements PersonService {

    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
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
    public List<Rol> findAllRolesFilter(String filter, String value) {
        return roleRepository.findAll();
    }
    
    @Override
    public Rol createNewRol(String name) {
        Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent()){
            throw new RolDuplicateException("El rol " + name +" ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return roleRepository.save(newRol);
    }

    private Optional <Rol> getRolByName (String rolName) {
        return roleRepository.findByName(rolName);
    }
}
