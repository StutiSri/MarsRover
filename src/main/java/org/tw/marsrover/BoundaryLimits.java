package org.tw.marsrover;

public class BoundaryLimits {
    private int upperLimit;
    private int lowerLimit;

    public BoundaryLimits(int upperLimit, int lowerLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }
}
