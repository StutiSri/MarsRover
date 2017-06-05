package org.tw.marsrover;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MarsRoverTest {
    @Test
    public void shouldTurnRoverAtCommandL(){
        TestRover rover = new TestRover(new Coordinates(1,2), Orientation.E);
        MarsRover marsRover = new MarsRover(new Plateau(new Coordinates(5,5)));
        marsRover.sendCommandsToRover("L", rover);
        TestRover expected = new TestRover(new Coordinates(1,2), Orientation.N);
        assertEquals(expected, rover);
    }
}