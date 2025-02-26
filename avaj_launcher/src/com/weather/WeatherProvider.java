package com.weather;

import com.simulator.Coordinates;
import java.util.Random;

public class WeatherProvider {
    private static weather.WeatherProvider instance = new weather.WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static weather.WeatherProvider getInstance() {
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        return weather[rand.nextInt(weather.length)];
    }
}