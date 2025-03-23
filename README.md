# Avaj Launcher

## Overview
Avaj Launcher is a Java-based aircraft simulation program designed as an introduction to Java programming at 42. It implements Object-Oriented principles and design patterns such as Observer, Singleton, and Factory.

## Features
- Simulates aircraft behavior based on changing weather conditions.
- Reads a scenario file and logs results to `simulation.txt`.
- Implements key Object-Oriented design patterns.

## Prerequisites
- Java (latest LTS version)
- Command-line environment with `javac` and `java` installed

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/avaj-launcher.git
   cd avaj-launcher
   ```
2. Ensure all Java files are correctly structured within packages following Java conventions.

## Usage
### Compile the Project
```sh
make compile
```
This command compiles all `.java` files into `.class` files.

### Run the Simulation
```sh
make run SCENARIO_FILE
```
Replace `SCENARIO_FILE` with the name of your scenario file. The output will be saved in `simulation.txt`.

### Clean Up
```sh
make clean
```
Removes all unnecessary compiled files.

## Scenario File Format
The scenario file consists of:
1. The first line: A positive integer indicating the number of simulation cycles.
2. Subsequent lines: Aircraft definitions in the format:
   ```
   TYPE NAME LONGITUDE LATITUDE HEIGHT
   ```
   - `TYPE`: JetPlane, Helicopter, or Baloon
   - `NAME`: Unique aircraft identifier
   - `LONGITUDE`, `LATITUDE`: Initial position
   - `HEIGHT`: Altitude (0-100)

## Simulation Rules
- Weather conditions: `SUN`, `RAIN`, `FOG`, `SNOW`
- Each aircraft reacts differently to weather changes.
- If an aircraft reaches height `0`, it lands and unregisters from the weather tower.
- Simulation logs all events in `simulation.txt`.

## Bonus Features
- Custom exceptions for handling invalid input.

