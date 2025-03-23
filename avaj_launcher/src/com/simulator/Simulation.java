package com.simulator;

import com.aircraft.Aircraft;
import com.error.ErrorParsing;
import com.weather.WeatherTower;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private int simulationNumber;
    private WeatherTower weatherTower;
    private static PrintWriter printWriter;
    private List<Flyable> aircrafts = new ArrayList<>();

    public Simulation() {
        this.simulationNumber = 0;
        this.weatherTower = new WeatherTower();

        try {
            printWriter = new PrintWriter("simulation.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSimulationNumber(int simulationNumber) {
        this.simulationNumber = simulationNumber;
    }

    public void setAircrafts(Flyable newAircrafts) {
        this.aircrafts.add(newAircrafts);
    }

    public void boarding() {
        for (Flyable aircraft : aircrafts) {
            aircraft.registerTower(weatherTower);
        }

//        try {
//            printWriter = new PrintWriter("simulation.txt", StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        int simulationCounter = this.simulationNumber;
        int counter = 0;

        while (simulationCounter > 0) {
            String simulationMessage = "### New simulation number : " + counter++ + " ###";
            System.out.println(simulationMessage);
            printWriter.println(simulationMessage);
            printWriter.flush();
            weatherTower.changeWeather();
            simulationCounter--;
        }
        printWriter.close();
    }

    public static void updateLogFile(String logs) {
        if (printWriter != null) {
            printWriter.println(logs);
            printWriter.flush();
        }
        else {
            System.out.println("No print writer available");
        }
    }
}
