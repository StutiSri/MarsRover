package org.tw.marsrover;


public class Coordinates {
    private int y;
    private int x;

    private BoundaryLimits boundaryLimits;

    public Coordinates(int x, int y, BoundaryLimits boundaryLimits) {
        this.boundaryLimits = boundaryLimits;
        if(!isValidCoordinate(x, y)) {
            System.out.print("Incorrect Coordinates Provided For Rover. They should be greater than zero and less " +
                    "than " + (this.boundaryLimits.getUpperLimit() + 1) + ".\nSkipping execution of rover commands.\n");
            return;
        }
        this.x = x;
        this.y = y;
    }

    private boolean isValidCoordinate(int x, int y) {
        if(x < boundaryLimits.getLowerLimit())
            return false;
        if(x > boundaryLimits.getUpperLimit())
            return false;
        if(y < boundaryLimits.getLowerLimit())
            return false;
        if(y > boundaryLimits.getUpperLimit())
            return false;
        return true;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    public Coordinates moveBy(int xChange, int yChange) {
        int newX = x + xChange;
        int newY = y + yChange;
        if(isValidCoordinate(newX, newY)){
            x = newX;
            y = newY;
            return this;
        }
        return null;
    }
}
