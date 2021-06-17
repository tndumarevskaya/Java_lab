import java.util.ArrayList;

public class ElevatorSystem implements Runnable {
    private int numberOfElevators;
    private ArrayList<Elevator> elevators = new ArrayList<Elevator>();
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private int numberOfPassengers;
    private int maxFloor;

    public ElevatorSystem(int numberOfElevators, int capacity, int maxFloor) {
        this.numberOfElevators = numberOfElevators;
        for (int i = 1; i <= numberOfElevators; i++) {
            elevators.add(new Elevator(i, capacity, maxFloor));
        }
        this.maxFloor = maxFloor;
    }

    public int getNumberOfElevators() {
        return numberOfElevators;
    }

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public synchronized void run() {
        while (true) {
            for (Elevator elevator : elevators) {
                //elevator.
                ArrayList<Passenger> directionDown = new ArrayList<Passenger>();
                ArrayList<Passenger> directionUp = new ArrayList<Passenger>();

                for (Passenger passenger : passengers) {
                    if (passenger.getDirection() == Direction.DOWN) {
                        directionDown.add(passenger);
                        passengers.remove(passenger);
                        System.out.println("passenger add");
                    } else if (passenger.getDirection() == Direction.UP) {
                        directionUp.add(passenger);
                        passengers.remove(passenger);
                        System.out.println("passenger add");
                    }
                }
                for (Passenger passenger : directionDown) {
                    if (elevator.getCurrentCapacity() + passenger.getWeight() < elevator.getCapacity()
                            && (elevator.getDirection() == Direction.DOWN || elevator.getDirection() == Direction.STAND)) {
                        elevator.addPassenger(passenger);
                        elevator.setDirection(Direction.DOWN);
                        directionDown.remove(passenger);
                    }
                    else
                        passengers.add(passenger);
                }
                for (Passenger passenger : directionUp) {
                    if (elevator.getCurrentCapacity() + passenger.getWeight() < elevator.getCapacity()
                            && (elevator.getDirection() == Direction.UP || elevator.getDirection() == Direction.STAND)) {
                        elevator.addPassenger(passenger);
                        elevator.setDirection(Direction.UP);
                        directionDown.remove(passenger);
                    } else
                        passengers.add(passenger);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}