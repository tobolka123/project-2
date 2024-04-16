package com.example.demo.AccountNOdetail;

import org.springframework.stereotype.Service;

import java.util.Random;

import java.util.UUID;
public class AccountNOdetail {
    private String name;
    private String surname;
    private String personID;

    public AccountNOdetail(String name, String surname, String personID) {
        this.name = name;
        this.surname = surname;
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personID='" + personID + "}";

    }
}