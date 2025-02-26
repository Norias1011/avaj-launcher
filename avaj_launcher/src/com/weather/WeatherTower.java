package com.weather;


import com.simulator.Tower;
import com.simulator.Coordinates;
import com.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}
