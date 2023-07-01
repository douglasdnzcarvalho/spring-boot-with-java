package com.example.springbootwithjava.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwithjava.exceptions.ResourceNotFoundException;
import com.example.springbootwithjava.models.Person;
import com.example.springbootwithjava.repositories.PersonRepository;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Searching all people");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info(String.format("Searching ID %s", id.toString()));
        return repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info(String.format("Updating ID %s", person.getId().toString()));
        Person entity = findById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info(String.format("Deleting ID %s", id.toString()));
        repository.deleteById(id);
    }
}
