package com.otus.pattern.builder;

public class UserBuilder {
    private String lastName;
    private String firstName;
    private String middleName;
    private String salutation;
    private String suffix;
    private String streetAddress;
    private String city;
    private String state;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomeOwner;

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public UserBuilder setSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public UserBuilder setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public UserBuilder setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public UserBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public UserBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public UserBuilder setIsFemale(boolean isFemale) {
        this.isFemale = isFemale;
        return this;
    }

    public UserBuilder setIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
        return this;
    }

    public UserBuilder setIsHomeOwner(boolean isHomeOwner) {
        this.isHomeOwner = isHomeOwner;
        return this;
    }

    public User build() {
        return new User(lastName, firstName, middleName, salutation, suffix, streetAddress, city, state, isFemale, isEmployed, isHomeOwner);
    }
}