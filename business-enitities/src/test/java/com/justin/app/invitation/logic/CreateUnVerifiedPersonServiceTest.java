package com.justin.app.invitation.logic;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class CreateUnVerifiedPersonServiceTest {

    @Inject
    public CreateUnVerifiedPersonService service;

    @Test
    public void loadContext(){
        Assert.assertThat(service,Matchers.notNullValue());
    }

    @Test
    public void shouldCreateSomething(){
        Assert.assertThat(service.createUnVerifiedPerson(null),Matchers.nullValue());
    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}
