import java.time.LocalDate;

public class Mission {
    private String name;
    private String destination;
    private MissionStatus status;
    private Rocket assignedRocket;
    private LocalDate launchDate;

    public Mission(String name, String destination) {
        this.name = name;
        this.destination = destination;
        this.status = MissionStatus.PLANNED;
    }

    public void launch(Rocket rocket) {
        this.assignedRocket = rocket;
        this.status = MissionStatus.LAUNCHED;
        this.launchDate = LocalDate.now();
        rocket.setAvailable(false);
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public MissionStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String info = name + " to " + destination + " [" + status + "]";
        if (assignedRocket != null) {
            info += " - Rocket: " + assignedRocket.getName();
        }
        if (launchDate != null) {
            info += " - Launched: " + launchDate;
        }
        return info;
    }
}
