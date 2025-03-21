package com.error;

public class ErrorSimulation extends RuntimeException {
    public ErrorSimulation() { super();}
    public ErrorSimulation(String message) { super(message); }
    public ErrorSimulation(Throwable cause) { super(cause); }
}
