package org.tw.marsrover;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tw.exception.IllegalCoordinateException;
import org.tw.testhelper.TestPlateau;
import org.tw.testhelper.TestRover;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class MarsRoverCommanderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Test
    public void shouldReturnOrientationWithStringInputForOrientation() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        assertEquals(Orientation.East, marsRoverCommander.getOrientation("E"));
    }

    @Test
    public void shouldPrintErrorMessageForInvalidOrientation() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String incorrectOrientation = "G";
        marsRoverCommander.getOrientation(incorrectOrientation);
        assertEquals("Incorrect Orientation Provided. Accepted Inputs : N, W, E, S.\nSkipping execution of rover " +
                "commands.\n", outContent.toString());
    }

    @Test
    public void shouldCreateRoverFromStringInput() throws IOException {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputPosition = "1 2 N";
        TestRover expected = new TestRover(new Coordinates(1, 2), Orientation.North);
        assertEquals(expected, marsRoverCommander.getRover(inputPosition, new Plateau(5, 5)));
    }

    @Test
    public void shouldPrintErrorMessageForRoverCoordinatesOutsideBoundary() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputPosition = "-1 2 N";
        marsRoverCommander.getRover(inputPosition, new Plateau(5, 5));
        String expectedOutput = "Incorrect X-Coordinate Provided For Rover. It should be greater than zero and less than " +
                "5.\nSkipping execution of rover commands.\n";
        inputPosition = "1 6 N";
        marsRoverCommander.getRover(inputPosition, new Plateau(5, 5));
        assertEquals(expectedOutput + "Incorrect Y-Coordinate Provided For Rover. It should be greater than zero and " +
                "less than " +
                "6.\nSkipping execution of rover commands.\n", outContent.toString());
    }

    @Test
    public void shouldCreatePlateauFromStringInput() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputUpperCoordinates = "5 5";
        TestPlateau expected = new TestPlateau(5, 5);
        assertEquals(expected, marsRoverCommander.getPlateau(inputUpperCoordinates));
    }

    @Test
    public void shouldPrintFinalPositionOfEachRoverAfterExecutingCommands() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("5 5\n1 2 N\nMLR\n2 3 S\nRRR\n\n"));
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.processInputForRover(bufferedReader);
        assertEquals("1 3 N\n2 3 E\n", outContent.toString());
    }
}
