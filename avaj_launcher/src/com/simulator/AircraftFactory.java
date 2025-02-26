package com.simulator;

import com.aircraft.*;
import com.simulator.Coordinates;
import com.simulator.Flyable;

import java.util.Locale;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, Coordinates coords) {
        long id = System.currentTimeMillis();
        switch (type.toLowerCase()) {
            case "helicopter":
                return new Helicopter(id, name, coords);
            case "jetplane":
                return new JetPlane(id, name, coords);
            case "baloon":
                return new Baloon(id, name, coords);
            default:
                throw new IllegalArgumentException("Invalid aircraft type: " + type);
        }
    }
}
