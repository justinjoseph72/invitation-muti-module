package com.justin.app.invitation.logic;

import com.justin.app.invitation.domain.Person;

public interface CreateVerfiedPersonService {

    Person createVerifiedPerson(final Person unverifiedPerson);
}
