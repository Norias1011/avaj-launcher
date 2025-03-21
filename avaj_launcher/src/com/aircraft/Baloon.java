package com.aircraft;

import com.aircraft.Aircraft;
import com.simulator.Flyable;
import com.simulator.Coordinates;
import com.weather.WeatherTower;
import com.utils.Logger;
import com.error.ErrorSimulation;

public class Baloon extends Aircraft  {

    public Baloon(long id, String name, Coordinates coordinates) {

        super(id, name, coordinates);
        super.setType("Baloon");
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates);
        switch (currentWeather) {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                Logger.log("Baloon", this.name, this.id, "Shine bright like a diamond");
                break;
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                Logger.log("Baloon", this.name, this.id, "I can see shit with this rain");
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() - 3);
                Logger.log("Baloon", this.name, this.id, "Who is smoking in here?!");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 15);
                Logger.log("Baloon", this.name, this.id, "Oh, the weather outside is frightful\n" +
                        "But the fire is so delightful\n" +
                        "And since we've no place to go\n" +
                        "Let it snow, let it snow, let it snow");
                break;
            default:
                throw new ErrorSimulation("Bad Weather name :" + currentWeather);

        }

        if (coordinates.getHeight() <= 0) {
            coordinates.setHeight(0);
            weatherTower.unregister(this);
        }
        if (coordinates.getHeight() > 100 ) {
            coordinates.setHeight(100);
        }
    }


}