package com.simulator;

import com.error.ErrorSimulation;
import com.simulator.Flyable;
import com.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    private int simulationNumber = 0;

    public void register(Flyable flyable) {
        Logger.logTower(flyable.getType(), flyable.getName(), flyable.getId(), "Has registered : Currently Flying");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Logger.logTower(flyable.getType(), flyable.getName(), flyable.getId(), "Has been unregistered : LANDED");
        observers.remove(flyable);
    }

    protected void conditionChanged() throws ErrorSimulation {
        List<Flyable> observersCopy = new ArrayList<>(observers);
        for (Flyable flyable : observersCopy) {
            flyable.updateConditions();
        }
    }

    public void setSimulationNumber(int simulationNumber) {
        this.simulationNumber = simulationNumber;
    }
}
