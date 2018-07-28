package com.justin.app.invitation.domain;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.justin.app.invitation.domain.attributes.person.Previewable;
import com.justin.app.invitation.domain.attributes.person.Verifiable;
import lombok.Getter;
import org.springframework.http.MediaType;

import java.math.BigInteger;
import java.util.Arrays;

@Getter
public final class Person implements Verifiable, Previewable {

    private final BigInteger personId;
    private final String givenName;
    private final String familyName;
    private final String email;
    private final String phone;
    private final String rememberMeId;
    private final byte[] selfie;
    private final MediaType mimeType;

    public String getDisplayName() {
        return givenName + " " + familyName;
    }

    @Override
    public boolean isPreviewable() {
        if (personId != null && selfie != null && mimeType != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isVerifiable() {
        if (personId != null && !Strings.isNullOrEmpty(rememberMeId)) {
            return true;
        }
        return false;
    }

    Person(final BigInteger personId, final String givenName, final String familyName, final String email, final String phone, final String rememberMeId, final byte[] selfie, final MediaType mimeType) {
        this.personId = personId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
        this.phone = phone;
        this.rememberMeId = rememberMeId;
        this.selfie = selfie;
        this.mimeType = mimeType;
    }

    private Person() {
        this.personId = null;
        this.givenName = null;
        this.familyName = null;
        this.email = null;
        this.phone = null;
        this.rememberMeId = null;
        this.selfie = null;
        this.mimeType = null;
    }

    public static Person.PersonBuilder builder() {
        return new Person.PersonBuilder();
    }

    public static class PersonBuilder {
        private BigInteger personId;
        private String givenName;
        private String familyName;
        private String email;
        private String phone;
        private String rememberMeId;
        private byte[] selfie;
        private MediaType mimeType;

        PersonBuilder() {
        }

        public Person.PersonBuilder personId(final BigInteger personId) {
            this.personId = personId;
            return this;
        }

        public Person.PersonBuilder givenName(final String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Person.PersonBuilder familyName(final String familyName) {
            this.familyName = familyName;
            return this;
        }

        public Person.PersonBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public Person.PersonBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        public Person.PersonBuilder rememberMeId(final String rememberMeId) {
            this.rememberMeId = rememberMeId;
            return this;
        }

        public Person.PersonBuilder selfie(final byte[] selfie) {
            this.selfie = selfie;
            return this;
        }

        public Person.PersonBuilder mimeType(final MediaType mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Person build() {
            return new Person(this.personId, this.givenName, this.familyName, this.email, this.phone, this.rememberMeId, this.selfie, this.mimeType);
        }

        public String toString() {
            return "Person.PersonBuilder(personId=" + this.personId + ", givenName=" + this.givenName + ", familyName=" + this.familyName + ", email=" + this.email + ", phone=" + this.phone + ", rememberMeId=" + this.rememberMeId + ", selfie=" + Arrays.toString(this.selfie) + ", mimeType=" + this.mimeType + ")";
        }
    }

    public Person verifyPerson(final String rememberMeId, byte[] selfie) {
        return Person.builder().personId(this.personId)
                .email(this.email).phone(this.phone)
                .givenName(this.givenName).familyName(this.familyName)
                .selfie(selfie).mimeType(MediaType.IMAGE_JPEG)
                .rememberMeId(rememberMeId).build();
    }

    public Person createUnverfiedPerson(final String givenName, final String familyName, final String email, final String phone) {
        return Person.builder().personId(null)
                .email(email).phone(phone)
                .givenName(givenName).familyName(familyName)
                .build();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equal(personId, person.personId) &&
                Objects.equal(givenName, person.givenName) &&
                Objects.equal(familyName, person.familyName) &&
                Objects.equal(email, person.email) &&
                Objects.equal(phone, person.phone) &&
                Objects.equal(rememberMeId, person.rememberMeId) &&
                Objects.equal(selfie, person.selfie) &&
                Objects.equal(mimeType, person.mimeType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personId, givenName, familyName, email, phone, rememberMeId, selfie, mimeType);
    }
}
