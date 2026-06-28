package elevator.domain;

public class ExternalRequest extends Request {

    private Direction direction;

    public ExternalRequest(Floor floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}