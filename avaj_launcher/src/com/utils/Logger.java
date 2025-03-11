package com.utils;

import com.simulator.Simulation;

public class Logger {
    public void log(String type, String name, int id, String message) {
        System.out.println(type + "#" + name + "(" + id + ") " + ": " + message);
        String messageLog = type + "#" + name + "(" + id + ") " + ": " + message;
        Simulation.updateLogFile(messageLog);
    }
}
