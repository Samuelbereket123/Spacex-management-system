public class Rocket {
    private String name;
    private int payloadCapacity;
    private boolean available;

    public Rocket(String name, int payloadCapacity) {
        this.name = name;
        this.payloadCapacity = payloadCapacity;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public int getPayloadCapacity() {
        return payloadCapacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + payloadCapacity + " kg, " + 
               (available ? "Available" : "In Use") + ")";
    }
}
