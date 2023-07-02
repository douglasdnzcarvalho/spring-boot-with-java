package com.example.springbootwithjava.converters;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.springbootwithjava.data.models.Person;
import com.example.springbootwithjava.data.viewobjects.PersonVO;
import com.example.springbootwithjava.mocks.MockPerson;

public class ObjectConverterTest {
    MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = ObjectConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        int listLength = 2;
        List<PersonVO> outputList = ObjectConverter.parseListObjects(inputObject.mockEntityList(listLength),
                PersonVO.class);
        for (int position = 0; position < listLength; position += 1) {
            PersonVO outputZero = outputList.get(position);
            Assert.assertEquals(Long.valueOf(position), outputZero.getId());
            Assert.assertEquals("First Name Test" + position, outputZero.getFirstName());
            Assert.assertEquals("Last Name Test" + position, outputZero.getLastName());
            Assert.assertEquals("Addres Test" + position, outputZero.getAddress());
            Assert.assertEquals((position % 2 == 0 ? "Male" : "Female"), outputZero.getGender());
        }
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = ObjectConverter.parseObject(inputObject.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        int listLength = 2;
        List<Person> outputList = ObjectConverter.parseListObjects(inputObject.mockVOList(listLength), Person.class);
        for (int position = 0; position < listLength; position += 1) {
            Person outputZero = outputList.get(position);
            Assert.assertEquals(Long.valueOf(position), outputZero.getId());
            Assert.assertEquals("First Name Test" + position, outputZero.getFirstName());
            Assert.assertEquals("Last Name Test" + position, outputZero.getLastName());
            Assert.assertEquals("Addres Test" + position, outputZero.getAddress());
            Assert.assertEquals((position % 2 == 0 ? "Male" : "Female"), outputZero.getGender());
        }
    }
}
