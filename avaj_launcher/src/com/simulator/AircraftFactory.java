package com.simulator;

import com.aircraft.*;
import com.error.ErrorParsing;
import com.simulator.Coordinates;
import com.simulator.Flyable;

import java.util.Locale;

public class AircraftFactory {

    private static long id = 0;
    public static Flyable newAircraft(String type, String name, Coordinates coords) throws ErrorParsing {
        if (coords.getLongitude() < 0 || coords.getLatitude() < 0 || coords.getHeight() < 0) {
            throw new ErrorParsing("Coordinates must be non-negative");
        }

        if (coords.getHeight() > 100) {
            coords.setHeight(100);
        }

        switch (type.toLowerCase()) {
            case "helicopter":
                return new Helicopter(id++, name, coords);
            case "jetplane":
                return new JetPlane(id++, name, coords);
            case "baloon":
                return new Baloon(id++, name, coords);
            default:
                throw new ErrorParsing("Invalid aircraft type: " + type);
        }
    }
}
