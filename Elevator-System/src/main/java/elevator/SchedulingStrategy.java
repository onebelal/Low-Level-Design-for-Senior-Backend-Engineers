package elevator;



import elevator.domain.Elevator;
import elevator.domain.ExternalRequest;

import java.util.List;

public interface SchedulingStrategy {
    Elevator assignElevator(ExternalRequest request, List<Elevator> elevators);
}