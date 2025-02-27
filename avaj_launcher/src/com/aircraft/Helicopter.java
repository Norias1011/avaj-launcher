package com.aircraft;

import com.aircraft.Aircraft;
import com.simulator.Flyable;
import com.simulator.Coordinates;
import com.weather.WeatherTower;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        // add the logic of this functions
    }

    @Override
    public void registerTower(WeatherTower tower) {
        tower.register(this);
    }
}
