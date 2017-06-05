package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public class Rover {
    private Coordinates coordinates;
    private Compass direction;

    public Rover(Coordinates coordinates, Compass direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void turnNintyDegreesLeft() {

    }

    public Compass getDirection() {
        return direction;
    }
}
