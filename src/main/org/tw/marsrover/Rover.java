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

    public void move(){
        if(!canMove())
            throw new CoordinatesOutOfBoundsException();
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

    private boolean canMove() {
        if(coordinates.getX() == 0 && direction == Orientation.E)
            return false;
        return true;
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
