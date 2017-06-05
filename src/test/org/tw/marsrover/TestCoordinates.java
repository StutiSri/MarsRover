package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public class TestCoordinates extends Coordinates {


    public TestCoordinates(int x, int y) {
        super(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        Coordinates coordinates = (Coordinates)obj;
        if(coordinates.getX() != this.getX())
            return false;
        if(coordinates.getY() != this.getY())
            return false;
        return true;
    }
}
