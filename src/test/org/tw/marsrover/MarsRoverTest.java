package org.tw.marsrover;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MarsRoverTest {
    @Test
    public void shouldTurnRoverAtCommandL(){
        TestRover rover = new TestRover(new Coordinates(1,2), Orientation.E);
        MarsRover marsRover = new MarsRover(new Plateau(5,5));
        marsRover.sendCommandsToRover("L", rover);
        TestRover expected = new TestRover(new Coordinates(1,2), Orientation.N);
        assertEquals(expected, rover);
    }
    @Test
    public void shouldTurnRoverAtCommandR(){
        TestRover rover = new TestRover(new Coordinates(3,2), Orientation.S);
        MarsRover marsRover = new MarsRover(new Plateau(5,5));
        marsRover.sendCommandsToRover("R", rover);
        TestRover expected = new TestRover(new Coordinates(3,2), Orientation.W);
        assertEquals(expected, rover);
    }
    @Test
    public void shouldMoveRoverInSameDirectionAtCommandM(){
        TestRover rover = new TestRover(new Coordinates(0,0), Orientation.E);
        MarsRover marsRover = new MarsRover(new Plateau(5, 5));
        marsRover.sendCommandsToRover("M", rover);
        TestRover expected = new TestRover(new Coordinates(1,0), Orientation.E);
        assertEquals(expected, rover);
    }
    @Test
    public void shouldMoveRoverAsPerTheCommand(){
        TestRover rover = new TestRover(new Coordinates(1,2), Orientation.N);
        MarsRover marsRover = new MarsRover(new Plateau(5, 5));
        marsRover.sendCommandsToRover("LMLMLMLMM", rover);
        TestRover expected = new TestRover(new Coordinates(1,3), Orientation.N);
        assertEquals(expected, rover);
    }
}
