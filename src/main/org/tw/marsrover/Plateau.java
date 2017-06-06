package org.tw.marsrover;


public class Plateau {
    Coordinates upperCoordinateLimits;
    private Coordinates lowerCoordinateLimits;

    public Plateau(int x, int y) {
        upperCoordinateLimits = new Coordinates(x, y);
        lowerCoordinateLimits = new Coordinates(0, 0);
    }

    public Coordinates getUpperCoordinateLimits() {
        return upperCoordinateLimits;
    }

    public Coordinates getLowerCoordinateLimits() {
        return lowerCoordinateLimits;
    }
}
