import java.util.ArrayList;

public class ElevatorCalls implements Runnable {
    private int maxFloor;
    private int currentFloor;
    private ElevatorSystem el_sys;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    int numberOfPassengers;

    public ElevatorCalls (int maxFloor, ElevatorSystem el_sys) {
        this.maxFloor = maxFloor;
        this.el_sys = el_sys;
    }
    public ElevatorSystem getEl_sys() {
        return el_sys;
    }

    public int getMaxFloor() {
        return maxFloor;
    }


    @Override
    public void run() {
        while (true) {
            numberOfPassengers = 1 + (int)(Math.random() * 10);
            currentFloor = (int)(Math.random() * maxFloor);
            for (int i = 1; i <= numberOfPassengers; i++) {
                Passenger person = new Passenger(i);
                person.setCurrentFloor(currentFloor);
                passengers.add(person);
            }
            for (Passenger passenger : passengers) {
                passenger.setNextFloor((int)Math.random() * maxFloor);
                if (passenger.getNextFloor() > passenger.getCurrentFloor())
                    passenger.setDirection(Direction.UP);
                else
                    passenger.setDirection(Direction.DOWN);
            }
            el_sys.setPassengers(passengers);

            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
