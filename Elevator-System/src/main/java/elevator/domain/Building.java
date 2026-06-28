package elevator.domain;

import java.util.Collections;
import java.util.List;

public class Building {

    private String name;

    private List<Floor> floors;

    private List<Elevator> elevators;

    public Building(String name, List<Floor> floors, List<Elevator> elevators) {
        this.name = name;
        this.floors = floors;
        this.elevators = elevators;
    }

    public String getName() {
        return name;
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }

    public List<Elevator> getElevators() {
        return Collections.unmodifiableList(elevators);
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", floors=" + floors +
                ", elevators=" + elevators +
                '}';
    }

    public void addElevators(Elevator elevator) {
        elevators.add(elevator);
    }
}