package com.example.fragmentrecycleview;

import android.app.Application;

import java.util.ArrayList;

public class Applicationclass extends Application
{

    public static ArrayList<person> people;


    @Override
    public void onCreate()
    {
        super.onCreate();

        people = new ArrayList<person>();
        people.add(new person("chuck norris","9254633"));
        people.add(new person("bihari pan","92546322"));
        people.add(new person("bubul","55896555"));

    }
}
