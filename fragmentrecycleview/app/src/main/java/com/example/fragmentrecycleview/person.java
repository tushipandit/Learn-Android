package com.example.fragmentrecycleview;

public class person {

    private String name;
    private String telno;

     public person()
     {

     }
    public person(String name, String telno) {
        this.name = name;
        this.telno = telno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

}
