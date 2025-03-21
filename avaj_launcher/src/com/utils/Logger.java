package com.utils;

import com.simulator.Simulation;

public class Logger {
    public static void log(String type, String name, long id, String message) {
        System.out.println(type + "#" + name + "(" + id + ") " + ": " + message);
        String messageLog = type + "#" + name + "(" + id + ") " + ": " + message;
        Simulation.updateLogFile(messageLog);
    }

    public static void logTower(String type, String name, long id, String message) {
        System.out.println("TOWER ALERT: " + type + " - " + name + "(" + id + ") " + ": " + message);
        String messageLog = "TOWER ALERT: " + type + " - " + name + "(" + id + ") " + ": " + message;
        Simulation.updateLogFile(messageLog);
    }
}
