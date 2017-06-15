package com.cristian.project;

import java.net.*;
import java.io.*;
/**
 * Created by cristian on 5/22/17.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        String origin = "1367+West+La+Deney+Dr,+Ontario,+CA";
        String destination = "Cal+Poly+Pomona";
        URL directions = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "4&key=AIzaSyDQDVMClxouZhweIle_9r9fqToIfaduXhE");
        URLConnection connection = directions.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()
        ));

        String inputLine;

        while(((inputLine = in.readLine()) != null)){
            System.out.println(inputLine);
        }
        in.close();
    }
}
