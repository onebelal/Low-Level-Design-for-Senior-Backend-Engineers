package elevator.domain;

public class InternalRequest {

    private Floor floor;
    private Direction direction;
    public InternalRequest(Floor floor, Direction direction) {
       this.floor=floor;
       this.direction=direction;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}