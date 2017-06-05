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
        switch (direction){
            case East:
                direction = Compass.North;
                return;
            case West:
                direction = Compass.South;
                return;
            case North:
                direction = Compass.West;
                return;
            case South:
                direction = Compass.East;
        }
    }

    public Compass getDirection() {
        return direction;
    }
}
