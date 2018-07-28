package com.justin.app.invitation.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.app.invitation.logic.model.CreatePersonRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    private MockMvc mockMvc;

    @Inject
    private WebApplicationContext webApplicationContext;

    private ObjectMapper mapper =new ObjectMapper();


    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/person").contentType(MediaType.APPLICATION_JSON)
        .content(getCreatePersonRequest()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String getCreatePersonRequest() throws JsonProcessingException {
        return mapper.writeValueAsString(CreatePersonRequest.builder().build());
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "com.justin.app")
    static class TestConfiguration {
    }
}
