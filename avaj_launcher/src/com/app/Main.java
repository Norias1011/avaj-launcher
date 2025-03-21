package com.app;


import com.error.ErrorParsing;
import com.utils.Parser;
import com.simulator.Simulation;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Parser.checkArgs(args);
            Simulation sim = new Simulation();
            Parser.parsingFile(new File(args[0]), sim);
            sim.boarding();
            // implement the code here
        } catch (ErrorParsing e) {
            System.out.println(e.getMessage());
        }
    }
}