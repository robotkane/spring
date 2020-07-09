package com.example.spring_boot_jpa.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    private Long id;

    @Before
    public void setUp() {
        assertNotNull(personRepository);
        Person person = new Person("xiao", 23);
        Person savedPerson = personRepository.saveAndFlush(person);
        savedPerson.setName("xiao1");
        personRepository.save(savedPerson);
        id = savedPerson.getId();
    }

    @Test
    public void should_get_person() {
        Optional<Person> personOptional = personRepository.findById(id);
        assertTrue(personOptional.isPresent());
        assertEquals("xiao1", personOptional.get().getName());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());

        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1, personList.size());

        personRepository.deleteAll();
    }

    @Test
    public void should_get_person_use_custom_query() {
        Optional<Person> personOptional = personRepository.findByNameCustomeQuery("xiao1");
        assertTrue(personOptional.isPresent());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());

        String pensionName = personRepository.findPersonNameById(id);
        assertEquals("xiao1", pensionName);
        System.out.println(id);

        personRepository.updatePersonNameById("xiao", id);
        Optional<Person> updateName = personRepository.findByNameCustomeQuery("xiao");
        assertTrue(updateName.isPresent());

        personRepository.deleteAll();
    }
}
