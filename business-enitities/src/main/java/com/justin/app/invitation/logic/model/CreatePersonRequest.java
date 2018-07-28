package com.justin.app.invitation.logic.model;

import com.google.common.base.Objects;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
@Builder
public class CreatePersonRequest {

    @NotBlank(message = "givenName cannot be blank")
    private String givenName;

    @NotBlank(message = "familyName cannot be blank")
    private String familyName;

    @Email(message = "not a valid email")
    @NotBlank(message = "email cannot be blank")
    private String email;

    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePersonRequest that = (CreatePersonRequest) o;
        return Objects.equal(givenName, that.givenName) &&
                Objects.equal(familyName, that.familyName) &&
                Objects.equal(email, that.email) &&
                Objects.equal(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(givenName, familyName, email, phone);
    }
}
