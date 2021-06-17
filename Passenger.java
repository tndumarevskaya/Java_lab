
public class Passenger {
    private int id;
    private int weight;
    private int currentFloor;
    private int nextFloor;
    private Direction direction;
    private static final int MAX_WEIGHT = 100;
    private static final int MIN_WEIGHT = 50;

    public Passenger(int id) {
        this.id = id;
        weight = (int)(Math.random() * (MAX_WEIGHT - MIN_WEIGHT)) + MIN_WEIGHT;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getWeight() {
        return weight;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }
}
