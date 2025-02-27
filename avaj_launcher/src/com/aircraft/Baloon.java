package com.aircraft;

import com.aircraft.Aircraft;
import com.simulator.Flyable;
import com.simulator.Coordinates;
import com.weather.WeatherTower;

public class Baloon extends Aircraft  {

    public Baloon(long id, String name, Coordinates coordinates) {
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