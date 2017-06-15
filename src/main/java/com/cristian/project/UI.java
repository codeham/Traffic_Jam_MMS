package com.cristian.project;

import java.util.Scanner;

/**
 * Created by cavinalopez on 5/26/2017.
 */
public class UI {

    public String introUsername(){
        Scanner k = new Scanner(System.in);
        System.out.print("Welcome, please enter your name : ");
        String name = k.nextLine();
        return name;
    }
    public int introMenu(){
        Scanner k = new Scanner(System.in);
        System.out.println("Choose from options below");
        System.out.println("1.New Schedule");
        System.out.println("2.My Schedule");
        int userChoice = k.nextInt();
        return userChoice;
    }
    public int scheduleChoice(){
        Scanner k = new Scanner(System.in);
        System.out.println("What's your schedule like ?");
        System.out.println("1. Monday / Wednesday / Friday");
        System.out.println("2. Tuesday / Thursday");
        System.out.println("3. Full Week Schedule");
        int numChoice = k.nextInt();
        return numChoice;
    }
    public String startTime(String day){
        Scanner k = new Scanner(System.in);
        System.out.println(day + "-");
        System.out.print("Start: ");
        String beginTime = k.nextLine();
        return beginTime;
    }
    public String endTime(String day){
        Scanner k = new Scanner(System.in);
        System.out.println(day + "-");
        System.out.print("Stop: ");
        String finishTime = k.nextLine();
        return finishTime;
    }
    public void timeinputError(String invalidTime){
        System.out.println(
                "Sorry, you entered " + "\"" + invalidTime + "\"" +
                        " a time not valid, try again");
    }
}
