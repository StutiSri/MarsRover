package org.tw.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoverTest {
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

    @Test
    public void roverShouldMoveOneGridToTheNorthAtMCommandWhenItIsFacingNorth(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Compass.North);
        rover.moveOneGridToTheNorth();
        assertEquals(new TestCoordinates(1,3), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheEastAtMCommandWhenItIsFacingEast(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Compass.East);
        rover.moveOneGridToTheEast();
        assertEquals(new TestCoordinates(2,2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheSouthAtMCommandWhenItIsFacingSouth(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Compass.South);
        rover.moveOneGridToTheSouth();
        assertEquals(new TestCoordinates(1,1), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheWestAtMCommandWhenItIsFacingWest(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Compass.West);
        rover.moveOneGridToTheWest();
        assertEquals(new TestCoordinates(0,2), rover.getCoordinates());
    }
}
