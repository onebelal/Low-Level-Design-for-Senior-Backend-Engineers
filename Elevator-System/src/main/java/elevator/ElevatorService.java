package elevator;

import elevator.domain.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElevatorService {
    private Map<String, Elevator> elevatorMap = new HashMap<>();
    private SchedulingStrategy schedulingStrategy;

    public ElevatorService(SchedulingStrategy schedulingStrategy) {
        this.schedulingStrategy =schedulingStrategy;
    }

    public Elevator createElevator(String name, Floor currentFloor, Direction direction, ElevatorState state, DoorState doorState) {
        Elevator elevator = new Elevator(name, currentFloor, direction, state, doorState);
        elevatorMap.put(name, elevator);
        return elevator;
    }

    public Elevator assignElevator(ExternalRequest request, List<Elevator> elevators) {
         Elevator elevator = schedulingStrategy.assignElevator(request, elevators);
         elevator.setDirection(request.getDirection());
         elevator.setState(ElevatorState.MOVING);
         return elevator;
    }

    public void selectFloor(Elevator elevator, InternalRequest request) {
        if (request.getFloor().getFloorNumber() >
                elevator.getCurrentFloor().getFloorNumber()) {
            elevator.getUpRequests().add(request.getFloor().getFloorNumber());
        } else {
            elevator.getDownRequests().add(request.getFloor().getFloorNumber());
        }
    }

    public void clearElevator(Elevator elevator) {
        elevator.getDownRequests().forEach(f->System.out.println(f));
        elevator.getDownRequests().clear();
        elevator.getUpRequests().forEach(f->System.out.println(f));
        elevator.getUpRequests().clear();
        elevator.setState(ElevatorState.IDLE);
        elevator.setDirection(Direction.IDLE);
    }
}
