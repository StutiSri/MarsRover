package org.tw.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoverTest {
    @Test
    public void roverShouldTurnFromNorthToWestAtLCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.N);
        rover.turnNintyDegreesLeft();
        assertEquals(Orientation.W, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromEastToNorthAtLCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.E);
        rover.turnNintyDegreesLeft();
        assertEquals(Orientation.N, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromSouthToWestAtRCommand(){
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.S);
        rover.turnNintyDegreesRight();
        assertEquals(Orientation.W, rover.getDirection());
    }

    @Test
    public void roverShouldMoveOneGridToTheNorthAtMCommandWhenItIsFacingNorth(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.N);
        rover.moveOneGridToTheNorth();
        assertEquals(new TestCoordinates(1,3), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheEastAtMCommandWhenItIsFacingEast(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.E);
        rover.moveOneGridToTheEast();
        assertEquals(new TestCoordinates(2,2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheSouthAtMCommandWhenItIsFacingSouth(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.S);
        rover.moveOneGridToTheSouth();
        assertEquals(new TestCoordinates(1,1), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheWestAtMCommandWhenItIsFacingWest(){
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.W);
        rover.moveOneGridToTheWest();
        assertEquals(new TestCoordinates(0,2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridInTheDirectionOfItsCurrentPositionAtCommanM(){
        Rover rover = new Rover(new TestCoordinates(3, 1), Orientation.E);
        rover.move();
        assertEquals(new TestCoordinates(4,1), rover.getCoordinates());
    }
}
