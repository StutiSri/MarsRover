package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public class TestRover extends Rover {
    public TestRover(Coordinates coordinates, Orientation direction) {
        super(coordinates, direction, new Plateau(5, 5));
    }

    @Override
    public boolean equals(Object obj) {
        Rover rover = (Rover)obj;
        if(!rover.toString().equals(toString()))
            return false;
        return true;
    }
}
