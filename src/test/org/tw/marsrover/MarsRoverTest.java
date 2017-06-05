package org.tw.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MarsRoverTest {
    @Test
    public void roverShouldTurnFromNorthToWestAtLCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Compass.North);
        rover.turnNintyDegreesLeft();
        assertEquals(Compass.West, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromEastToNorthAtLCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Compass.East);
        rover.turnNintyDegreesLeft();
        assertEquals(Compass.North, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromSouthToWestAtRCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Compass.South);
        rover.turnNintyDegreesRight();
        assertEquals(Compass.West, rover.getDirection());
    }
}
