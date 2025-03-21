package com.error;

public class ErrorParsing extends Exception {
    public ErrorParsing() { super();}
    public ErrorParsing(String message) { super(message); }
    public ErrorParsing(Throwable cause) { super(cause); }
}

