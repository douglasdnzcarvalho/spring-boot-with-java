package com.example.springbootwithjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.springbootwithjava.models.Person;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Searching all people");
        List<Person> people = new ArrayList<>();

        for (int i = 0; i <= 10; i += 1) {
            Person person = mockPerson(i);
            people.add(person);
        }

        return people;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Name " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Uberlândia");
        person.setGender("male");
        return person;
    }

    public Person findById(String id) {
        logger.info(String.format("Searching ID %s", id));

        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Douglas");
        person.setLastName("Carvalho");
        person.setAddress("Uberlândia");
        person.setGender("male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person");
        return person;
    }

    public Person delete(String id) {
        logger.info("Deleting id " + id);
        return findById(id);
    }
}
