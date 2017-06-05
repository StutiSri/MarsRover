package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public class Rover {
    private Coordinates coordinates;
    private Orientation direction;

    public Rover(Coordinates coordinates, Orientation direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void turnNintyDegreesLeft() {
        direction = direction.left;
    }

    public Orientation getDirection() {
        return direction;
    }

    public void turnNintyDegreesRight() {
        direction = direction.right;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void moveOneGridToTheNorth() {
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
    }

    public void moveOneGridToTheEast() {
        coordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY() );
    }

    public void moveOneGridToTheSouth() {
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
    }

    public void moveOneGridToTheWest() {
        coordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY());
    }

    public void move() {
        switch (direction){
            case East:
                moveOneGridToTheEast();
                return;
            case West:
                moveOneGridToTheWest();
                return;
            case North:
                moveOneGridToTheNorth();
                return;
            case South:
                moveOneGridToTheSouth();
        }
    }
}
