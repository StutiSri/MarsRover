package org.tw.marsrover;


public class Position {
    private Coordinates coordinates;
    private Orientation direction;

    public Position(Coordinates coordinates, Orientation direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.left;
    }

    public void turnRight() {
        direction = direction.right;
    }

    public Position moveOneStepToTheNorth() {
        Coordinates newCoordinates = coordinates.moveBy(0,1);
        if(newCoordinates!=null)
            return this;
        return null;
    }

    public Position moveOneStepToTheEast() {
        Coordinates newCoordinates = coordinates.moveBy(1,0);
        if(newCoordinates!=null)
            return this;
        return null;
    }

    public Position moveOneStepToTheSouth() {
        Coordinates newCoordinates = coordinates.moveBy(0,-1);
        if(newCoordinates!=null)
            return this;
        return null;
    }

    public Position moveOneStepToTheWest() {
        Coordinates newCoordinates = coordinates.moveBy(-1,0);
        if(newCoordinates!=null)
            return this;
        return null;
    }

    public Position move() {
        switch (direction) {
            case East:
                return moveOneStepToTheEast();
            case West:
                return moveOneStepToTheWest();
            case North:
                return moveOneStepToTheNorth();
            case South:
                return moveOneStepToTheSouth();
        }
        return null;
    }

    @Override
    public String toString() {
        return coordinates.toString() + " " + direction;
    }

    public Orientation getOrientation() {
        return direction;
    }
}
