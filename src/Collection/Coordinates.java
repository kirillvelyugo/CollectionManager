package Collection;

import Expections.InvalidValue;

/**
 * Coordinates class - use for store coordinates of product
 */
public class Coordinates {
    private long x;
    private Long y; // Max value: 315, Field can't be null

    public long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    /**
     * Set X coordinate
     * @param x X coordinate
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * Set Y coordinate
     * @param y Y coordinate
     * @throws InvalidValue if y > 315 or y is null
     */
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
