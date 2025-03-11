package com.simulator;

import com.aircraft.Aircraft;
import com.error.ErrorParsing;
import com.weather.WeatherTower;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private int simulationNumber;
    private WeatherTower weatherTower;
    private static PrintWriter printWriter;
    private static List<Flyable> aircrafts = new ArrayList<>();

    public Simulation() {
        this.simulationNumber = 0;
        this.weatherTower = new WeatherTower();
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

        try {
            printWriter = new PrintWriter("simulation.txt", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int simulationCounter = this.simulationNumber;
        int counter = 0;

        while (simulationCounter > 0) {
            String simulationMessage = "### New simulation number : " + counter++ + " ###";
            System.out.println(simulationMessage);
            printWriter.println(simulationMessage);
            weatherTower.changeWeather();
            simulationCounter--;
        }
    }

    public static void updateLogFile(String logs) {
        printWriter.println(logs);
    }
}
