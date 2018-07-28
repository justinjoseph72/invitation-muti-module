package com.justin.app.invitation.controllers;

import com.justin.app.invitation.logic.CreateUnVerifiedPersonService;
import com.justin.app.invitation.logic.model.CreatePersonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final CreateUnVerifiedPersonService createUnVerifiedPersonService;

    @PostMapping("/person")
    public ResponseEntity<?> createUnVerifiedPerson(@RequestBody CreatePersonRequest request){
        createUnVerifiedPersonService.createUnVerifiedPerson(request);
       ResponseEntity returnEntity = ResponseEntity.ok().build();
       return returnEntity;
    }
}
