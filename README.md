# SpaceX Management System

A simple command-line application for managing SpaceX rockets and missions.

## Features

- Add and manage rockets with payload capacity
- Create missions with destinations
- Launch missions by assigning rockets
- Track mission status and rocket availability
- Pre-loaded with sample SpaceX rockets (Falcon 9, Falcon Heavy, Starship)

## Requirements

- Java 8 or higher

## How to Run

1. Compile all Java files:
```bash
javac *.java
```

2. Run the application:
```bash
java SpaceXManagementSystem
```

## Usage

The system provides a menu-driven interface with the following options:

1. **Add Rocket** - Register a new rocket with name and payload capacity
2. **List Rockets** - View all available rockets and their status
3. **Add Mission** - Create a new mission with name and destination
4. **List Missions** - View all missions and their current status
5. **Launch Mission** - Assign a rocket to a mission and launch it
6. **Exit** - Close the application

## Example

```
=== SpaceX Management System ===
1. Add Rocket
2. List Rockets
3. Add Mission
4. List Missions
5. Launch Mission
6. Exit
Choice: 5

--- Missions ---
1. Starlink-45 to Low Earth Orbit [PLANNED]
2. Mars Colony to Mars [PLANNED]
Select mission number: 1

--- Rockets ---
1. Falcon 9 (Capacity: 22800 kg, Available)
2. Falcon Heavy (Capacity: 63800 kg, Available)
3. Starship (Capacity: 100000 kg, Available)
Select rocket number: 1

Mission launched successfully!
```

## Project Structure

- `SpaceXManagementSystem.java` - Main application and manager class
- `Rocket.java` - Rocket entity with capacity and availability
- `Mission.java` - Mission entity with status tracking
- `MissionStatus.java` - Enum for mission states (PLANNED, LAUNCHED, COMPLETED, FAILED)
