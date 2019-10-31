package com.example.recyclerviewworking;

public class person {

    private String name;
    private String surname;
    private String preferences;


    public person(String name , String surname , String preferences) {

        this.name=name;
        this.surname=surname;
        this.preferences=preferences;


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

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
