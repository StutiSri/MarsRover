package org.tw.marsrover;

import org.tw.exception.CoordinatesOutOfBoundsException;

public class Rover {
    private Coordinates coordinates;
    private Orientation direction;
    private Plateau plateau;

    public Rover(Coordinates coordinates, Orientation direction, Plateau plateau) {

        this.coordinates = coordinates;
        this.direction = direction;
        this.plateau = plateau;
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
        if (coordinates.getY() >= plateau.getUpperCoordinateLimits().getY())
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
    }

    public void moveOneGridToTheEast() {
        if (coordinates.getX() >= plateau.getUpperCoordinateLimits().getX())
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY());
    }

    public void moveOneGridToTheSouth() {
        if (coordinates.getY() <= plateau.getLowerCoordinateLimits().getY())
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
    }

    public void moveOneGridToTheWest() {
        if (coordinates.getX() <= plateau.getLowerCoordinateLimits().getX())
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY());
    }

    public void move() {
        switch (direction) {
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


    public void execute(char command) {
            switch (command) {
                case 'M':
                    move();
                    return;
                case 'L':
                    turnNintyDegreesLeft();
                    return;
                case 'R':
                    turnNintyDegreesRight();
            }
    }

    @Override
    public String toString() {
        return coordinates.getX() + " " + coordinates.getY() + " " + direction;
    }
}
