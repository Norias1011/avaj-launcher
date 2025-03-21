package com.simulator;

import com.weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);

    public abstract long getId();

    public abstract String getName();

    public abstract String getType();
}
