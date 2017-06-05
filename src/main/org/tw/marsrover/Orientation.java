package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public enum Orientation {
    North, East, West, South;

    static {
        North.left = West;
        West.left = South;
        South.left = East;
        East.left = North;

        North.right = East;
        East.right = South;
        South.right = West;
        West.right = North;

    }

    Orientation left;
    Orientation right;
}
