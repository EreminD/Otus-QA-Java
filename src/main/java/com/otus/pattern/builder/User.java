package com.otus.pattern.builder;

import java.util.Objects;

public class User {
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

    User(String lastName, String firstName, String middleName, String salutation, String suffix, String streetAddress, String city, String state, boolean isFemale, boolean isEmployed, boolean isHomeOwner) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.salutation = salutation;
        this.suffix = suffix;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomeOwner = isHomeOwner;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }

    public void setHomeOwner(boolean homeOwner) {
        isHomeOwner = homeOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isFemale == user.isFemale &&
                isEmployed == user.isEmployed &&
                isHomeOwner == user.isHomeOwner &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(middleName, user.middleName) &&
                Objects.equals(salutation, user.salutation) &&
                Objects.equals(suffix, user.suffix) &&
                Objects.equals(streetAddress, user.streetAddress) &&
                Objects.equals(city, user.city) &&
                Objects.equals(state, user.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, salutation, suffix, streetAddress, city, state, isFemale, isEmployed, isHomeOwner);
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salutation='" + salutation + '\'' +
                ", suffix='" + suffix + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                ", isHomeOwner=" + isHomeOwner +
                '}';
    }


}
