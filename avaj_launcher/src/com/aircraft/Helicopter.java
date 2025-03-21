package com.aircraft;

import com.aircraft.Aircraft;
import com.error.ErrorSimulation;
import com.simulator.Flyable;
import com.simulator.Coordinates;
import com.utils.Logger;
import com.weather.WeatherTower;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {

        super(id, name, coordinates);
        super.setType("Helicopter");
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates);
        switch (currentWeather) {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                Logger.log("Helicopter", this.name, this.id, "Today is a good day");
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                Logger.log("Helicopter", this.name, this.id, "God's peeing");
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                Logger.log("Helicopter", this.name, this.id, "Better fly low with this fog");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                Logger.log("Helicopter", this.name, this.id, "Santa Claus is coming!");
                break;
            default:
                throw new ErrorSimulation("Bad Weather name :" + currentWeather);

        }
    }
}
