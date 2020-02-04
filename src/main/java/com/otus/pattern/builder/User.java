package com.otus.pattern.builder;

import javax.jws.soap.SOAPBinding;

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

    private User() {
        // private constructor
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }

    public static Builder builder() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;

            return this;
        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;

            return this;
        }

        public Builder setMiddleName(String middleName) {
            User.this.middleName = middleName;

            return this;
        }

        public Builder setSalutation(String salutation) {
            User.this.salutation = salutation;

            return this;
        }

        public Builder setSuffix(String suffix) {
            User.this.suffix = suffix;

            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            User.this.streetAddress = streetAddress;

            return this;
        }

        public Builder setCity(String city) {
            User.this.city = city;

            return this;
        }

        public Builder setState(String state) {
            User.this.state = state;

            return this;
        }

        public Builder setFemale(boolean isFemale) {
            User.this.isFemale = isFemale;

            return this;
        }

        public Builder setEmployed(boolean isEmployed) {
            User.this.isEmployed = isEmployed;

            return this;
        }

        public Builder setHomeOwner(boolean isHomeOwner) {
            User.this.isHomeOwner = isHomeOwner;

            return this;
        }

        public User build() {
            return User.this;
        }

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
