package org.tw.testhelper;

import org.tw.marsrover.Plateau;

/**
 * Created by stutis on 6/7/17.
 */
public class TestPlateau extends Plateau {
    public TestPlateau(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Plateau plateau2 = (Plateau)obj;
        TestCoordinates upperCoordinatesForPlateau2 = new TestCoordinates(plateau2.getUpperCoordinateLimits().getX(),
                plateau2.getUpperCoordinateLimits().getY());
        TestCoordinates loweCoordinatesForPlateau2 = new TestCoordinates(plateau2.getLowerCoordinateLimits().getX(),
                plateau2.getLowerCoordinateLimits().getY());;

        Plateau plateau1 = this;
        TestCoordinates upperCoordinatesForPlateau1 = new TestCoordinates(plateau1.getUpperCoordinateLimits().getX(),
                plateau1.getUpperCoordinateLimits().getY());
        TestCoordinates loweCoordinatesForPlateau1 = new TestCoordinates(plateau1.getLowerCoordinateLimits().getX(),
                plateau1.getLowerCoordinateLimits().getY());;

        if(!loweCoordinatesForPlateau1.equals(loweCoordinatesForPlateau1))
            return false;
        return upperCoordinatesForPlateau1.equals(upperCoordinatesForPlateau2);
    }

}
