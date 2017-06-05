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

    public void turnNintyDegreesRight() {
        switch (direction){
            case East:
                direction = Compass.South;
                return;
            case West:
                direction = Compass.North;
                return;
            case North:
                direction = Compass.East;
                return;
            case South:
                direction = Compass.West;
        }
    }

    public void moveOneGridToTheNorth() {
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void moveOneGridToTheEast() {
        coordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY() );
    }

    public void moveOneGridToTheSouth() {

    }
}
