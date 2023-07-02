package com.example.springbootwithjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwithjava.converters.ObjectConverter;
import com.example.springbootwithjava.data.models.Person;
import com.example.springbootwithjava.data.viewobjects.PersonVO;
import com.example.springbootwithjava.exceptions.ResourceNotFoundException;
import com.example.springbootwithjava.repositories.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<PersonVO> findAll() {
        return ObjectConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        Person entity = repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return ObjectConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        Person entity = ObjectConverter.parseObject(person, Person.class);
        return ObjectConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        Person entity = repository
            .findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return ObjectConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
