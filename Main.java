import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of floors");
        int numberOfFloors = sc.nextInt();
        System.out.println("Enter number of elevators");
        int numberOfElevators = sc.nextInt();
        System.out.println("Enter max capacity of elevators");
        int capacity = sc.nextInt();

        ElevatorSystem el_sys = new ElevatorSystem(numberOfElevators, capacity, numberOfFloors);
        ElevatorCalls people = new ElevatorCalls(numberOfFloors, el_sys);
        Thread peopleThread = new Thread(people);
        peopleThread.start();
        Thread el_sysThread = new Thread(el_sys);
        el_sysThread.start();
    }
}
