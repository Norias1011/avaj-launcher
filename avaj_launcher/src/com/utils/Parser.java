package com.utils;

import com.error.ErrorParsing;
import com.simulator.AircraftFactory;
import com.simulator.Coordinates;
import com.simulator.Simulation;
import com.simulator.Tower;
import com.weather.WeatherTower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private static BufferedReader reader;
    private static Simulation simulation;
    public static void checkArgs(String[] args) throws ErrorParsing {
        if (args.length != 1) {
            throw new ErrorParsing("You need to add only one .txt file with the scenario you want to test");
        }
    }

    public static void parsingFile(File file, Simulation simulation) throws ErrorParsing {
        try {
            reader = new BufferedReader(new FileReader(file));
            simulation.setSimulationNumber(Integer.parseInt(reader.readLine()));
            // not sure of the line below, need to check other way of reading the file
            while (reader.ready()) {
                String line = reader.readLine();
                String[] tokens = line.split(" ");
                simulation.setAircrafts(AircraftFactory.newAircraft(tokens[0], tokens[1], new Coordinates(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]))));
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            throw new ErrorParsing(e.getMessage());
        }
    }
}
