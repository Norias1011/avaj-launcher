package com.aircraft;

import com.simulator.Coordinates;
import com.simulator.Flyable;
import com.weather.WeatherTower;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower;
    private String type;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public abstract void updateConditions();

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public long getId() { return id; }

    public String getName() { return name; }

    public String getType() { return type; }

    public String setType(String type) { return this.type = type; }
}
