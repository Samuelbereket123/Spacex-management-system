import java.util.*;
import java.time.LocalDate;

public class SpaceXManagementSystem {
    public static void main(String[] args) {
        SpaceXManager manager = new SpaceXManager();
        manager.run();
    }
}

class SpaceXManager {
    private List<Rocket> rockets = new ArrayList<>();
    private List<Mission> missions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        loadSampleData();
        
        while (true) {
            displayMenu();
            int choice = getIntInput();
            
            switch (choice) {
                case 1: addRocket(); break;
                case 2: listRockets(); break;
                case 3: addMission(); break;
                case 4: listMissions(); break;
                case 5: launchMission(); break;
                case 6: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== SpaceX Management System ===");
        System.out.println("1. Add Rocket");
        System.out.println("2. List Rockets");
        System.out.println("3. Add Mission");
        System.out.println("4. List Missions");
        System.out.println("5. Launch Mission");
        System.out.println("6. Exit");
        System.out.print("Choice: ");
    }

    private void addRocket() {
        System.out.print("Rocket name: ");
        String name = scanner.nextLine();
        System.out.print("Payload capacity (kg): ");
        int capacity = getIntInput();
        
        rockets.add(new Rocket(name, capacity));
        System.out.println("Rocket added successfully!");
    }

    private void listRockets() {
        if (rockets.isEmpty()) {
            System.out.println("No rockets available");
            return;
        }
        System.out.println("\n--- Rockets ---");
        for (int i = 0; i < rockets.size(); i++) {
            System.out.println((i + 1) + ". " + rockets.get(i));
        }
    }

    private void addMission() {
        System.out.print("Mission name: ");
        String name = scanner.nextLine();
        System.out.print("Destination: ");
        String destination = scanner.nextLine();
        
        missions.add(new Mission(name, destination));
        System.out.println("Mission added successfully!");
    }

    private void listMissions() {
        if (missions.isEmpty()) {
            System.out.println("No missions available");
            return;
        }
        System.out.println("\n--- Missions ---");
        for (int i = 0; i < missions.size(); i++) {
            System.out.println((i + 1) + ". " + missions.get(i));
        }
    }

    private void launchMission() {
        if (missions.isEmpty() || rockets.isEmpty()) {
            System.out.println("Need at least one mission and one rocket");
            return;
        }
        
        listMissions();
        System.out.print("Select mission number: ");
        int missionIdx = getIntInput() - 1;
        
        if (missionIdx < 0 || missionIdx >= missions.size()) {
            System.out.println("Invalid mission");
            return;
        }
        
        listRockets();
        System.out.print("Select rocket number: ");
        int rocketIdx = getIntInput() - 1;
        
        if (rocketIdx < 0 || rocketIdx >= rockets.size()) {
            System.out.println("Invalid rocket");
            return;
        }
        
        Mission mission = missions.get(missionIdx);
        Rocket rocket = rockets.get(rocketIdx);
        
        if (mission.getStatus() == MissionStatus.LAUNCHED) {
            System.out.println("Mission already launched");
            return;
        }
        
        mission.launch(rocket);
        System.out.println("Mission launched successfully!");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Enter a valid number: ");
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    private void loadSampleData() {
        rockets.add(new Rocket("Falcon 9", 22800));
        rockets.add(new Rocket("Falcon Heavy", 63800));
        rockets.add(new Rocket("Starship", 100000));
        
        missions.add(new Mission("Starlink-45", "Low Earth Orbit"));
        missions.add(new Mission("Mars Colony", "Mars"));
    }
}
