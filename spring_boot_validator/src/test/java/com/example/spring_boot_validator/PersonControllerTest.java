package com.example.spring_boot_validator;

import com.example.spring_boot_validator.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_get_person_correctly() throws Exception {
        Person person = new Person();
        person.setName("SnailClimb");
        person.setSex("Man");
        person.setClassId("82938390");
        person.setEmail("Snailclimb@qq.com");

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(person)))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("SnailClimb"))
                .andExpect(MockMvcResultMatchers.jsonPath("classId").value("82938390"))
                .andExpect(MockMvcResultMatchers.jsonPath("sex").value("Man"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("Snailclimb@qq.com"));
    }

    @Test
    public void should_check_person_value() throws Exception {
        Person person = new Person();
        person.setSex("Man22");
        person.setClassId("82938390");
        person.setEmail("SnailClimb");

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(person)))
                .andExpect(MockMvcResultMatchers.jsonPath("sex").value("sex 值不在可选范围"))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("name 不能为空"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("email 格式不正确"));
    }
}
