package org.tw.marsrover;

import org.junit.Test;
import org.tw.exception.CoordinatesOutOfBoundsException;
import org.tw.testhelper.TestCoordinates;

import static org.junit.Assert.assertEquals;


public class RoverTest {
    @Test
    public void roverShouldTurnFromNorthToWestAtLCommand() {
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.North, new Plateau(5, 5));
        rover.turnNintyDegreesLeft();
        assertEquals(Orientation.West, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromEastToNorthAtLCommand() {
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.East, new Plateau(5, 5));
        rover.turnNintyDegreesLeft();
        assertEquals(Orientation.North, rover.getDirection());
    }

    @Test
    public void roverShouldTurnFromSouthToWestAtRCommand() {
        Rover rover = new Rover(new Coordinates(1, 2), Orientation.South, new Plateau(5, 5));
        rover.turnNintyDegreesRight();
        assertEquals(Orientation.West, rover.getDirection());
    }

    @Test
    public void roverShouldMoveOneGridToTheNorthAtMCommandWhenItIsFacingNorth() {
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.North, new Plateau(5, 5));
        rover.moveOneGridToTheNorth();
        assertEquals(new TestCoordinates(1, 3), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheEastAtMCommandWhenItIsFacingEast() {
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.East, new Plateau(5, 5));
        rover.moveOneGridToTheEast();
        assertEquals(new TestCoordinates(2, 2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheSouthAtMCommandWhenItIsFacingSouth() {
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.South, new Plateau(5, 5));
        rover.moveOneGridToTheSouth();
        assertEquals(new TestCoordinates(1, 1), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridToTheWestAtMCommandWhenItIsFacingWest() {
        Rover rover = new Rover(new TestCoordinates(1, 2), Orientation.West, new Plateau(5, 5));
        rover.moveOneGridToTheWest();
        assertEquals(new TestCoordinates(0, 2), rover.getCoordinates());
    }

    @Test
    public void roverShouldMoveOneGridInTheDirectionOfItsCurrentPositionAtCommandM() {
        Rover rover = new Rover(new TestCoordinates(3, 1), Orientation.East, new Plateau(5, 5));
        rover.move();
        assertEquals(new TestCoordinates(4, 1), rover.getCoordinates());
    }

    @Test(expected = CoordinatesOutOfBoundsException.class)
    public void shouldThrowExceptionAtCommandMWhenRoverIsInUpperLeftCornerFacingWest() {
        Rover rover = new Rover(new TestCoordinates(0, 5), Orientation.West, new Plateau(5, 5));
        rover.move();
    }

    @Test(expected = CoordinatesOutOfBoundsException.class)
    public void shouldThrowExceptionAtCommandMWhenRoverIsInUpperLeftCornerFacingNorth() {
        Rover rover = new Rover(new TestCoordinates(0, 5), Orientation.North, new Plateau(5, 5));
        rover.move();
    }

    @Test(expected = CoordinatesOutOfBoundsException.class)
    public void shouldThrowExceptionAtCommandMWhenRoverIsInLowerRightCornerFacingSouth() {
        Rover rover = new Rover(new TestCoordinates(5, 0), Orientation.South, new Plateau(5, 5));
        rover.move();
    }

    @Test(expected = CoordinatesOutOfBoundsException.class)
    public void shouldThrowExceptionAtCommandMWhenRoverIsInLowerRightCornerFacingEast() {
        Rover rover = new Rover(new TestCoordinates(5, 0), Orientation.East, new Plateau(5, 5));
        rover.move();
    }

}
