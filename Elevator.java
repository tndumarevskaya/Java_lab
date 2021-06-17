import java.util.ArrayList;

public class Elevator {
    private int id;
    private int capacity;
    private Direction direction = Direction.STAND;
    private int currentCapacity = 0;
    private int currentFloor = 0;
    private int nextFloor = 0;
    private int maxFloor;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public Elevator(int id, int capacity, int maxFloor) {
        this.id = id;
        this.capacity = capacity;
        this.maxFloor = maxFloor;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }

    public void setCurrentCapacity(int weightOfPassenger) {
        this.currentCapacity += weightOfPassenger;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.isEmpty())
            passengers.add(passenger);
        else {
            int index = passengers.size() - 1;
            while (passengers.get(index).getNextFloor() > passenger.getNextFloor()) {
                index--;
            }
            passengers.add(index, passenger);
        }
    }

    public void removePassengers(int currentFloor) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getNextFloor() == currentFloor) {
                System.out.println("The elevator " + id + " went up to the " + currentFloor + "floor");
                System.out.println("The passenger " + id + "went out");
                passengers.remove(i);
            }
            else if (passengers.get(i).getNextFloor() > currentFloor)
                break;
        }
    }

}
