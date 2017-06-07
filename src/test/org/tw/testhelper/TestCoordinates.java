package org.tw.testhelper;

import org.tw.marsrover.Coordinates;

public class TestCoordinates extends Coordinates {


    public TestCoordinates(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Coordinates coordinates = (Coordinates) obj;
        if (coordinates.getX() != this.getX())
            return false;
        return coordinates.getY() == this.getY();
    }
}
