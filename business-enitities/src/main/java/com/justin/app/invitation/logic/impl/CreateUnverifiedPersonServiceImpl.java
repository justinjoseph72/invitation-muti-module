package com.justin.app.invitation.logic.impl;

import com.justin.app.invitation.domain.Person;
import com.justin.app.invitation.logic.CreateUnVerifiedPersonService;
import com.justin.app.invitation.logic.model.CreatePersonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUnverifiedPersonServiceImpl implements CreateUnVerifiedPersonService {

    @Override
    public Person createUnVerifiedPerson(CreatePersonRequest request) {
        log.info("I am in the new service implementation");
        return null;
    }
}
