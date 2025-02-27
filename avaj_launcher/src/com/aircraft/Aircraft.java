package com.aircraft;

import com.simulator.Coordinates;
import com.simulator.Flyable;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public abstract void updateConditions();
}
