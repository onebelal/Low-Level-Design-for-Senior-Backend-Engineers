package elevator.domain;

public abstract class Request {

    public Floor floor;

    public Request(Floor floors) {
        this.floor = floors;
    }

    public Floor getFloor() {
        return floor;
    }
}
