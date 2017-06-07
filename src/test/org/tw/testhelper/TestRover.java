package org.tw.testhelper;

import org.tw.marsrover.Coordinates;
import org.tw.marsrover.Orientation;
import org.tw.marsrover.Plateau;
import org.tw.marsrover.Rover;

/**
 * Created by stutis on 6/5/17.
 */
public class TestRover extends Rover {
    public TestRover(Coordinates coordinates, Orientation direction) {
        super(coordinates, direction, new Plateau(5, 5));
    }

    @Override
    public boolean equals(Object obj) {
        Rover rover = (Rover) obj;
        if (!rover.toString().equals(toString()))
            return false;
        return true;
    }
}
