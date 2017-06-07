package org.tw.marsrover;

import org.junit.Test;
import sun.misc.IOUtils;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class MarsRoverStarterTest {
    @Test
    public void shouldTurnRoverAtCommandL() {
        TestRover rover = new TestRover(new Coordinates(1, 2), Orientation.E);
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter(new Plateau(5, 5));
        marsRoverStarter.sendCommandsToRover("L", rover);
        TestRover expected = new TestRover(new Coordinates(1, 2), Orientation.N);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldTurnRoverAtCommandR() {
        TestRover rover = new TestRover(new Coordinates(3, 2), Orientation.S);
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter(new Plateau(5, 5));
        marsRoverStarter.sendCommandsToRover("R", rover);
        TestRover expected = new TestRover(new Coordinates(3, 2), Orientation.W);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldMoveRoverInSameDirectionAtCommandM() {
        TestRover rover = new TestRover(new Coordinates(0, 0), Orientation.E);
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter(new Plateau(5, 5));
        marsRoverStarter.sendCommandsToRover("M", rover);
        TestRover expected = new TestRover(new Coordinates(1, 0), Orientation.E);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldMoveRoverAsPerTheCommand() {
        TestRover rover = new TestRover(new Coordinates(1, 2), Orientation.N);
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter(new Plateau(5, 5));
        marsRoverStarter.sendCommandsToRover("LMLMLMLMM", rover);
        TestRover expected = new TestRover(new Coordinates(1, 3), Orientation.N);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldReturnOrientationWithStringInputForOrientation() {
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter(new Plateau(5, 5));
        assertEquals(Orientation.E, marsRoverStarter.getOrientation("E"));
    }

    @Test
    public void shouldCreateRoverFromStringInput() throws IOException {
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter(new Plateau(5,5));
        String inputPosition = "1 2 N";
        TestRover expected = new TestRover(new Coordinates(1,2), Orientation.N);
        assertEquals(expected, marsRoverStarter.getRover(inputPosition));
    }
}
