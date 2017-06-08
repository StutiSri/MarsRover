package org.tw.marsrover;

import org.junit.Test;
import org.tw.testhelper.TestCoordinates;
import org.tw.testhelper.TestRover;

import static org.junit.Assert.assertEquals;


public class RoverTest {
    @Test
    public void roverShouldTurnAtLeftCommand() {
        Rover rover = new Rover(new Position(new TestCoordinates(1,2), Orientation.North));
        rover.execute(CommandType.Left);
        assertEquals(Orientation.West, rover.getPosition().getOrientation());
    }

    @Test
    public void roverShouldMoveOneGridInTheDirectionOfItsCurrentPositionAtMoveCommand() {
        Rover rover = new Rover(new Position(new TestCoordinates(1,2), Orientation.North));
        rover.execute(CommandType.Move);
        TestRover expectedRover = new TestRover(new Position(new TestCoordinates(1,3),Orientation.North));
        assertEquals(expectedRover, rover);
    }

    @Test
    public void shouldExecuteASeriesOfCommandsToGiveRoversCurrentPosition(){
        Rover rover = new Rover(new Position(new TestCoordinates(1,2), Orientation.North));
        rover.runCommands("LRMRMLLM");
        TestRover expectedRover = new TestRover(new Position(new TestCoordinates(1,3),Orientation.West));
        assertEquals(expectedRover, rover);
    }
}
