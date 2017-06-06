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
        if(coordinates.getY() + 1 > 4)
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
    }

    public void moveOneGridToTheEast() {
        if(coordinates.getX() + 1 > 4)
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY() );
    }

    public void moveOneGridToTheSouth() {
        if(coordinates.getY() - 1 < 0)
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
    }

    public void moveOneGridToTheWest() {
        if(coordinates.getX() - 1 < 0)
            throw new CoordinatesOutOfBoundsException();
        coordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY());
    }

    public void move(){
        switch (direction){
            case E:
                moveOneGridToTheEast();
                return;
            case W:
                moveOneGridToTheWest();
                return;
            case N:
                moveOneGridToTheNorth();
                return;
            case S:
                moveOneGridToTheSouth();
        }
    }


    public void execute(char command)  {
        switch (command){
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
