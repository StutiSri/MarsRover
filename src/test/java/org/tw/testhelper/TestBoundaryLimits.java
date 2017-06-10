package org.tw.testhelper;

import org.tw.marsrover.BoundaryLimits;

public class TestBoundaryLimits extends BoundaryLimits {
    public TestBoundaryLimits(int upperLimit, int lowerLimit) {
        super(upperLimit, lowerLimit);
    }

    @Override
    public boolean equals(Object obj) {
        BoundaryLimits boundaryLimits = (BoundaryLimits)obj;
        if(boundaryLimits.getUpperLimit() != getUpperLimit())
            return false;
        return boundaryLimits.getLowerLimit() == getLowerLimit();
    }
}
