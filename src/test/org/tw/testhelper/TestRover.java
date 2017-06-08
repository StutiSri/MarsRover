package org.tw.testhelper;

import org.tw.marsrover.Position;
import org.tw.marsrover.Rover;

/**
 * Created by stutis on 6/5/17.
 */
public class TestRover extends Rover {
    public TestRover(Position position) {
        super(position);
    }

    @Override
    public boolean equals(Object obj) {
        Rover rover = (Rover) obj;
        return rover.toString().equals(toString());
    }
}
