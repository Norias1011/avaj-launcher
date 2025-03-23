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
        int lineNumber = 1;
        try {
            reader = new BufferedReader(new FileReader(file));
            simulation.setSimulationNumber(checkSimulationNumber(reader.readLine()));   //(Integer.parseInt(reader.readLine()));
            // not sure of the line below, need to check other way of reading the file
            lineNumber++;
            while (reader.ready()) {
                String line = reader.readLine();
                String[] tokens = line.split(" ");
                checkLines(tokens, lineNumber);
                simulation.setAircrafts(AircraftFactory.newAircraft(tokens[0], tokens[1], new Coordinates(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]))));
                lineNumber++;
            }
            reader.close();
        } catch (IOException | NumberFormatException | ErrorParsing e) {
            throw new ErrorParsing("ERROR Line " + lineNumber + " : " + e.getMessage());
        }
    }

    public static void checkLines(String[] lines, int lineNumber) throws ErrorParsing {
        if (lines == null || lines.length != 5) {
            throw new ErrorParsing("Wrong Input, Should be : Type of Aircraft, Name of Aircraft and Coordinates");
        }

        checkTypeOfAircraft(lines[0]);
        checkNameOfAircraft(lines[1]);
        checkCoordinatesOfAircraft(lines[2], lines[3], lines[4]);
    }

    public static void checkTypeOfAircraft(String line) throws ErrorParsing {
        if (!line.equals("Helicopter") && !line.equals("Baloon") && !line.equals("JetPlane")) {
            throw new ErrorParsing("Wrong Type of Aircraft: " + line);
        }
    }

    public static void checkNameOfAircraft(String line) throws ErrorParsing {
        if (!line.matches("[A-Za-z0-9]+")) {
            throw new ErrorParsing("Only alphanumeric name allowed for Aircraft name: " + line);
        }
    }

    public static void checkCoordinatesOfAircraft(String longS, String latS, String heightS) throws ErrorParsing {
        int longitude = coordinateStringToInt(longS);
        int latitude = coordinateStringToInt(latS);
        int height = coordinateStringToInt(heightS);

        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new ErrorParsing("Wrong Coordinates (only positive): " + longS + ", " + latS + ", " + height);
        }
    }

    public static int coordinateStringToInt(String coordinates) throws ErrorParsing {
        try {
            return Integer.parseInt(coordinates);
        }
        catch (NumberFormatException e) {
            throw new ErrorParsing("Wrong Coordinates: " + coordinates);
        }
    }

    public static int checkSimulationNumber(String simNumber) throws ErrorParsing {
        try {
            int number = Integer.parseInt(simNumber);
            if (number < 0) {
                throw new ErrorParsing("Wrong SimulationNumber (only positive number): " + simNumber);
            }
            return number;
        }
        catch (NumberFormatException e) {
            throw new ErrorParsing("Wrong Simulation Number: " + simNumber);
        }
    }
}
