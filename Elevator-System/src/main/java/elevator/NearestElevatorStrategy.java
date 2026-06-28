package elevator;


import elevator.domain.Direction;
import elevator.domain.Elevator;
import elevator.domain.ElevatorState;
import elevator.domain.ExternalRequest;

import java.util.List;

public class NearestElevatorStrategy
        implements SchedulingStrategy {
    @Override
    public Elevator assignElevator(ExternalRequest request, List<Elevator> elevators) {

            Elevator bestElevator = null;
            Elevator idleElevator = null;
            int minDistance = Integer.MAX_VALUE;

            for (Elevator elevator : elevators) {

                if (elevator.getState() == ElevatorState.MAINTENANCE) {
                    continue;
                }

                if (elevator.getState() == ElevatorState.IDLE) {
                    if (idleElevator == null) {
                        idleElevator = elevator;
                    }
                    continue;
                }

                if (elevator.getDirection() == request.getDirection()) {

                    boolean canServe =
                            request.getDirection() == Direction.UP
                                    ? request.getFloor().getFloorNumber() >= elevator.getCurrentFloor().getFloorNumber()
                                    : request.getFloor().getFloorNumber() <= elevator.getCurrentFloor().getFloorNumber();

                    if (canServe) {

                        int distance = Math.abs(
                                request.getFloor().getFloorNumber()
                                        - elevator.getCurrentFloor().getFloorNumber());

                        if (distance < minDistance) {
                            minDistance = distance;
                            bestElevator = elevator;
                        }
                    }
                }
            }

            return bestElevator != null ? bestElevator : idleElevator;

    }
}