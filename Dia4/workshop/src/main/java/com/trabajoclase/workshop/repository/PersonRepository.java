<<<<<<< HEAD
package com.trabajoclase.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajoclase.workshop.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByProgrammingLanguageEquals(String programmingLanguage);
    // @Query("SELECT p FROM Person p WHERE p.name = ?1")
    // List<Person> findByName(String name);
    // List<Person> findByName(String name);
    // List<Person> findByNameAndLastName(String name, String lastName);
    // List<Person> findByNameOrLastName(String name, String lastName);
    // List<Person> findByNameLike(String name);
    // List<Person> findByNameNotLike(String name);
    // List<Person> findByNameIn(List<String> names);
    // List<Person> findByNameNotIn(List<String> names);

}
=======
package com.trabajoclase.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajoclase.workshop.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByProgrammingLanguageEquals(String programmingLanguage);
    // @Query("SELECT p FROM Person p WHERE p.name = ?1")
    // List<Person> findByName(String name);
    // List<Person> findByName(String name);
    // List<Person> findByNameAndLastName(String name, String lastName);
    // List<Person> findByNameOrLastName(String name, String lastName);
    // List<Person> findByNameLike(String name);
    // List<Person> findByNameNotLike(String name);
    // List<Person> findByNameIn(List<String> names);
    // List<Person> findByNameNotIn(List<String> names);

}
>>>>>>> e72a82451d046761bea5f9c05d0bf48e9ff512c1
