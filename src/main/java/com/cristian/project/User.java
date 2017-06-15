package com.cristian.project;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Created by cristian on 5/22/17.
 */
public class User {
    private String name;
    private HashMap<String, LocalTime[]> schedule = new HashMap<String, LocalTime[]>();
    User(String name){
        this.name = name;
    }
    public String getUser(){ return name;}
    public void setUser(String name){ this.name = name;}
    public HashMap<String, LocalTime[]> getHashmap(){ return schedule;}
    public void printMap(){
        System.out.println("_______________________");
        System.out.println("Name: " + name);
        System.out.println("Size of HashMap: " + schedule.size());
        System.out.println("Content in HashMap: ");
        for (String x : schedule.keySet()){
            System.out.println("Day - " + x);
            System.out.println(Arrays.toString(schedule.get(x)));
        }
    }
    public void populateMap(String day, LocalTime[] startTime){
        schedule.put(day, startTime);
    }
    public void exportUser(){

    }
}
