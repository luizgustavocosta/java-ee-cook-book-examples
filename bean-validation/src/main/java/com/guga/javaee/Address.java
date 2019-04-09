package com.guga.javaee;

import javax.validation.constraints.NotNull;

public class Address {

    private final String zipCode;
    private final String city;

    public Address(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }


    @NotNull(message="would be nice if we had one", payload=Severity.Info.class)
    public String getZipCode() {
        return zipCode;
    }

    @NotNull(message="the city is mandatory", payload=Severity.Error.class)
    String getCity() {
        return city;
    }
}
