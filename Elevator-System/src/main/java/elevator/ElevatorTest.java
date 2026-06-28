package elevator;

import elevator.domain.*;

import java.util.ArrayList;
import java.util.List;


public class ElevatorTest {

    public static void main(String args[]) {

        System.out.println("Create a building with configurable floors and elevators.");

        ElevatorService elevatorService = new ElevatorService(new NearestElevatorStrategy());
        Elevator elevator = elevatorService.createElevator("Elevator-1", new Floor(0), Direction.UP, ElevatorState.IDLE, DoorState.CLOSED);
        List<Elevator> elevators = List.of(elevator);

        BuildingService buildingService = new BuildingService();
        Building building = buildingService.createBuilding("Jannat Heights", List.of(new Floor(0), new Floor(2)), new ArrayList<>());
        // adding more elevators
        buildingService.addElevators(elevator, building);

        System.out.println("Building Created " + building);

        ExternalRequest request = new ExternalRequest(new Floor(5),Direction.UP);
        Elevator assignElevator = elevatorService.assignElevator(request, elevators);
        elevatorService.selectFloor(assignElevator, new InternalRequest(new Floor(5), Direction.UP));
        System.out.println("Assigned elevator : Going in direction "+ assignElevator.getDirection());
        elevatorService.clearElevator(elevator);

        ExternalRequest downRequest = new ExternalRequest(new Floor(2), Direction.DOWN);
        Elevator assignElevator1 = elevatorService.assignElevator(downRequest, elevators);
        elevatorService.selectFloor(assignElevator1, new InternalRequest(new Floor(2), Direction.DOWN));
        System.out.println("Assigned elevator : Going in direction "+ assignElevator1.getDirection());
        elevatorService.clearElevator(assignElevator1);


    }
}
