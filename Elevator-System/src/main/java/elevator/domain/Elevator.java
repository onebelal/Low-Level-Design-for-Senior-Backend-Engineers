package elevator.domain;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.random.RandomGenerator;

public class Elevator {

    private int id;

    private String name;

    private Floor currentFloor;

    private Direction direction;

    private ElevatorState state;

    private DoorState doorState;

    private NavigableSet<Integer> upRequests = new TreeSet<>();

    private NavigableSet<Integer> downRequests =
            new TreeSet<>(Comparator.reverseOrder());

    public Elevator(String name, Floor currentFloor, Direction direction, ElevatorState state, DoorState doorState) {
        this.id = RandomGenerator.getDefault().nextInt();
        this.name = name;
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.state = state;
        this.doorState = doorState;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public DoorState getDoorState() {
        return doorState;
    }

    public NavigableSet<Integer> getUpRequests() {
        return upRequests;
    }

    public NavigableSet<Integer> getDownRequests() {
        return downRequests;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public void accept(int floors) {
        if(this.getDirection().UP.equals(Direction.UP))
            this.getUpRequests().add(floors);
        else if(this.getDirection().DOWN.equals(Direction.DOWN))
            this.getDownRequests().add(floors);
    }
}