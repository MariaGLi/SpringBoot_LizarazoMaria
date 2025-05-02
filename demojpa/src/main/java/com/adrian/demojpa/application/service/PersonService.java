package com.adrian.demojpa.application.service;

import java.util.List;


import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;

public interface PersonService {
    public List<Person> findAllByFilter(String filter, String value);
    public List<Rol> findAllRolesFilter(String filter, String value);
    public Rol createNewRol(String name);
}
