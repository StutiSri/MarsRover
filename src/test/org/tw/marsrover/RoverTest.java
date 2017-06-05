package org.tw.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoverTest {
    @Test
    public void roverShouldTurnFromNorthToWestAtLCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.North);
        rover.turnNintyDegreesLeft();
        assertEquals(Orientation.West, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromEastToNorthAtLCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.East);
        rover.turnNintyDegreesLeft();
        assertEquals(Orientation.North, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromSouthToWestAtRCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.South);
        rover.turnNintyDegreesRight();
        assertEquals(Orientation.West, rover.getDirection());
    }

    @Test
    public void roverShouldMoveOneGridToTheNorthAtMCommandWhenItIsFacingNorth(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.North);
        rover.moveOneGridToTheNorth();
        assertEquals(new TestCoordinates(1,3), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheEastAtMCommandWhenItIsFacingEast(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.East);
        rover.moveOneGridToTheEast();
        assertEquals(new TestCoordinates(2,2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheSouthAtMCommandWhenItIsFacingSouth(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.South);
        rover.moveOneGridToTheSouth();
        assertEquals(new TestCoordinates(1,1), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheWestAtMCommandWhenItIsFacingWest(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.West);
        rover.moveOneGridToTheWest();
        assertEquals(new TestCoordinates(0,2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridInTheDirectionOfItsCurrentPositionAtCommanM(){
        Rover rover = new Rover(new TestCoordinates(3, 1), Orientation.East);
        rover.move();
        assertEquals(new TestCoordinates(4,1), rover.getCoordinates());
    }
}
