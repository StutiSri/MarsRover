package org.tw.marsrover;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MarsRoverTest {
    @Test
    public void shouldTurnRoverAtCommandL(){
        Rover rover = new Rover(new Coordinates(1,2), Orientation.East);
        MarsRover marsRover = new MarsRover(new Plateau(new Coordinates(5,5)));
        marsRover.commandRover("L", rover);
        Rover expected = new Rover(new Coordinates(1,2), Orientation.North);
        assertEquals(expected, rover);
    }
}
