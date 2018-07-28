package com.justin.app.invitation.logic;

import com.justin.app.invitation.domain.Person;
import com.justin.app.invitation.logic.model.CreatePersonRequest;

public interface CreateUnVerifiedPersonService {
     Person createUnVerifiedPerson(final CreatePersonRequest request);
}
