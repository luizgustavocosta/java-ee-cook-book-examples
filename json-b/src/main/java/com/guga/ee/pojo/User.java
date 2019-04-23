package com.guga.ee.pojo;

import java.time.ZonedDateTime;

public class User {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String fullName;
    private final ZonedDateTime dob;

    private User(String firstName,
                 String middleName,
                 String lastName,
                 String fullName,
                 ZonedDateTime dob) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public ZonedDateTime getDob() {
        return dob;
    }


    public static final class UserBuilder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String fullName;
        private ZonedDateTime dob;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder withDob(ZonedDateTime dob) {
            this.dob = dob;
            return this;
        }

        public User build() {
            return new User(this.firstName,
                    this.middleName,
                    this.lastName,
                    this.fullName,
                    this.dob);
        }
    }
}
