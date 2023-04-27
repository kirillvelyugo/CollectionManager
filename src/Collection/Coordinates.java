package Collection;

import Expections.InvalidValue;

public class Coordinates {
    private long x;
    private Long y; // Max value: 315, Field can't be null

    public long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(Long y) throws InvalidValue{
        if (y == null){throw new InvalidValue("y shouldn't be null");}
        if (y > 315){throw new InvalidValue("y shouldn't be grader than 315");}
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates: x = " + this.x + ", y = " + this.y;
    }
}
