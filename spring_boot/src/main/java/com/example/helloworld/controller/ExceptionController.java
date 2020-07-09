package com.example.helloworld.controller;

import com.example.helloworld.domain.Person;
import com.example.helloworld.exception.ResourceNotFoundException;
import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionController {
    @GetMapping("/resourceNotFound")
    public void throwException() {
        Person p = new Person(1L, "SnailClimb");
        throw new ResourceNotFoundException(ImmutableMap.of("person id:", p.getId()));
    }
}
