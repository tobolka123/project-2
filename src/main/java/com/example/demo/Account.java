package com.example.demo;

import java.util.Random;

import java.util.UUID;

public class Account {
    private String name;
    private String surname;
    private String personID;
    private String uuid;
    private static int nextId = 1;
    private long id = nextId++;

    public Account(String name, String surname, String personID) {
        this.name = name;
        this.surname = surname;
        this.personID = personID;
        this.uuid = UUID.randomUUID().toString();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personID='" + personID + '\'' +
                ", uuid='" + uuid + '\'' +
                ", id=" + id +
                '}';
    }
}