# avaj-launcher

Introduction

Avaj Launcher is a Java-based aircraft simulation program designed as an introduction to Java programming at 42. It utilizes Object-Oriented principles and design patterns such as Observer, Singleton, and Factory.

Objectives

The program simulates aircraft behavior based on different weather conditions. The simulation reads a scenario file, processes aircraft movements, and logs the results in simulation.txt.

Requirements

Java (latest LTS version)

No external libraries, build tools, or code generators are allowed

Ensure javac and java are available in your terminal

Installation

Clone the repository:

git clone https://github.com/your-username/avaj-launcher.git
cd avaj-launcher

Ensure all Java files are correctly placed within packages following Java conventions.

Compilation

To compile the project, run:

make compile

This will compile all .java files into .class files.

Running the Simulation

To execute the program, run:

make run scenario.txt

Replace scenario.txt with your own scenario file. The simulation output will be saved in simulation.txt.

Cleaning Up

To remove unnecessary compiled files, run:

make clean

Scenario File Format

The first line of the scenario file contains a positive integer representing the number of simulation cycles. Each following line describes an aircraft using the format:

TYPE NAME LONGITUDE LATITUDE HEIGHT

TYPE: JetPlane, Helicopter, or Baloon

NAME: Unique aircraft name

LONGITUDE, LATITUDE: Initial coordinates

HEIGHT: Altitude (0-100)

Simulation Rules

Weather types: SUN, RAIN, FOG, SNOW

Each aircraft reacts differently based on weather conditions

If an aircraft reaches height 0, it lands and unregisters from the weather tower

Messages are logged in simulation.txt

Bonus Features

Custom exceptions for invalid input handling
