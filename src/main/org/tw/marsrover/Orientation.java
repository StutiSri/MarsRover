package org.tw.marsrover;

public enum Orientation {
    North {
        public String toString() {
            return "N";
        }
    }, East{
        public String toString() {
            return "E";
        }
    }, West{
        public String toString() {
            return "W";
        }
    }, South{
        public String toString() {
            return "S";
        }
    };

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
