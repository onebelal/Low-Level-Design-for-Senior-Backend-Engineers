package elevator;

import elevator.domain.Building;
import elevator.domain.Elevator;
import elevator.domain.Floor;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingService {

    private Map<String, Building> buildingMap;

    public BuildingService() {
        buildingMap = new HashMap<>();
    }

    public Building createBuilding(String name, List<Floor> floors, List<Elevator> elevatorList) {
        Building building = new Building(name, floors, elevatorList);
        buildingMap.put(name, building);
        return building;
    }

    public void addElevators(Elevator elevator, Building building) {
        building.addElevators(elevator);
    }
}
