package com.example.springbootwithjava.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.springbootwithjava.models.Person;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

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
}
