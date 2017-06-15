package com.cristian.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cavinalopez on 6/13/2017.
 */
public class MapData {
    private String origin, destination;
    MapData(String origin, String destination){
        this.origin = origin;
        this.destination = destination;
    }
    public String getOrigin(){ return origin; }
    public void setOrigin(String origin){ this.origin = origin; }
    public String getDestination(){ return destination; }
    public void setDestination(String origin){ this.destination = destination; }
    public String fetchData() throws Exception{
        XMLReader getAPI = new XMLReader();
        String apiKey = getAPI.main();
        URL directions = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" +
                origin + "&destination=" + destination +
                "4&key=" + apiKey);
        URLConnection connection = directions.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String finalLines = " ";
        String inputLine;
        while((inputLine = in.readLine()) != null){
            finalLines += "\n" + inputLine;
        }

        in.close();
        buildJSON(finalLines);
        return " ";
    }
    public String buildJSON(String finalLines){
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        System.out.println(finalLines);
        Gson gson = new Gson();
        gson.toJson(finalLines);
//        String str = gson.fromJson()
        System.out.println(finalLines);
        return " ";
    }
}
