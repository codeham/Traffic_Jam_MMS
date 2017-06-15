package com.cristian.project;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 * Point A - Computer / API
 * > Sends traffic updates based on user's schedule
 * Point B - User / Phone / SMS ?
 * > Receives traffic updates at specific times aligned with schedule
 * Created by cristian on 5/22/17.
 */
public class Main {
    private final String[] Fullweek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private final String[] MWF = {"Monday", "Wednesday", "Friday"};
    private final String[] TTH = {"Tuesday", "Thursday"};
    private String username;
    private UI userInterface;
    private User client;
    public static void main(String[] args) throws Exception {
//        Main client = new Main();
//        client.introPrompt();
//        client.exportUser();
        String origin = "Covina,+CA";
        String destination = "Cal+Poly+Pomona";
        MapData time = new MapData(origin, destination);
        time.fetchData();
    }
    public void introPrompt() {
        userInterface = new UI();
        username = userInterface.introUsername();
        int mainOption = userInterface.introMenu();
        if (mainOption == 1){ chooseSchedule();}
    }
    public void chooseSchedule(){
        int choice = userInterface.scheduleChoice();
        if (choice == 1){ createSchedule(MWF, username);}
        else if (choice == 2){ createSchedule(TTH, username);}
        else { createSchedule(Fullweek, username);}
    }
    public void createSchedule(String[] scheduleDays, String name){
        client = new User(name);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

        for (String x : scheduleDays){
            LocalTime startTime = null;
            LocalTime endTime = null;
            while (startTime == null || endTime == null) {
                startTime = timeParser(userInterface.startTime(x), formatter);
                endTime = timeParser(userInterface.endTime(x), formatter);
                LocalTime[] completeTimes = {startTime, endTime};
                client.populateMap(x, completeTimes);
            }
        }
    }
    public LocalTime timeParser(String tempTime, DateTimeFormatter formatter){
        LocalTime time = null;
        try{
            return LocalTime.parse(tempTime, formatter);
        }catch(DateTimeParseException e){
            userInterface.timeinputError(tempTime);
        }
        return time;
    }
    public void exportUser(){
        client.printMap();
    }
}