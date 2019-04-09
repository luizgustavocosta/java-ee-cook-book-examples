package com.guga.javaee;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "Please, provide a valid first name", payload = Severity.Error.class)
    private final String firstName;
    @NotNull(message = "Middle name not filled", payload = Severity.Info.class)
    private final String middleName;
    @NotNull(message = "Please, provide a valid last name", payload = Severity.Error.class)
    private final String lastName;
    @Email @NotNull
    private final String email;

    public User(String firstName, String middleName, String lastName, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
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
}
