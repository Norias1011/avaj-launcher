package com.aircraft;

import com.error.ErrorSimulation;
import com.simulator.Flyable;
import com.simulator.Coordinates;
import com.utils.Logger;
import com.weather.WeatherTower;

public class JetPlane extends Aircraft {

    public JetPlane(long id, String name, Coordinates coordinates) {

        super(id, name, coordinates);
        super.setType("JetPlane");
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates);
        switch (currentWeather) {
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                Logger.log("JetPlane", this.name, this.id, "Sunny, Yesterday my life was filled with rain");
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                Logger.log("JetPlane", this.name, this.id, "I'm crying!!");
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                Logger.log("JetPlane", this.name, this.id, "Snoop Dogg is in the sky?");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                Logger.log("JetPlane", this.name, this.id, "I hate the snow!");
                break;
            default:
                throw new ErrorSimulation("Bad Weather name :" + currentWeather);

        }
    }
}
