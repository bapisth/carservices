package com.urja.carservices.models;

/**
 * Created by hemendra on 26-07-2016.
 */
public class Person {
    private String name;
    private PersonAddress personAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonAddress getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(PersonAddress personAddress) {
        this.personAddress = personAddress;
    }
}
