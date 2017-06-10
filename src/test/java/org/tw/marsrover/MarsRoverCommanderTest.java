package org.tw.marsrover;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tw.testhelper.TestBoundaryLimits;
import org.tw.testhelper.TestCoordinates;
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
        String orientationEast = "E";
        assertEquals(Orientation.East, Orientation.fromString(orientationEast));
    }

    @Test
    public void shouldPrintErrorMessageForInvalidOrientation() {
        String incorrectOrientation = "G";
        Orientation.fromString(incorrectOrientation);
        assertEquals("Incorrect Orientation Provided. Accepted Inputs : N, W, E, S.\nSkipping execution of rover " +
                "commands.\n", outContent.toString());
    }

    @Test
    public void shouldCreateRoverFromStringInput() throws IOException {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputPosition = "1 2 N";
        TestRover expected = new TestRover(new Position(new Coordinates(1,2, new BoundaryLimits(5,0)),
                                                Orientation.North));
        assertEquals(expected, marsRoverCommander.getRover(inputPosition, new BoundaryLimits(5, 0)));
    }

    @Test
    public void shouldPrintErrorMessageForRoverCoordinatesOutsideBoundary() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputPosition = "-1 2 N";
        marsRoverCommander.getRover(inputPosition, new BoundaryLimits(5, 5));
        String expectedOutput = "Incorrect Coordinates Provided For Rover. They should be greater than zero and less " +
                "than 6.\nSkipping execution of rover commands.\n";
        inputPosition = "1 6 N";
        marsRoverCommander.getRover(inputPosition, new BoundaryLimits(5, 0));
        assertEquals(expectedOutput + "Incorrect Coordinates Provided For Rover. They should be greater than zero " +
                "and less than 6.\nSkipping execution of rover commands.\n", outContent.toString());
    }

    @Test
    public void shouldCreateBoundaryLimitsFromStringInput() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputUpperCoordinates = "5 5";
        TestBoundaryLimits expected = new TestBoundaryLimits(5, 0);
        assertEquals(expected, marsRoverCommander.getBoundaryLimits(inputUpperCoordinates));
    }

    @Test
    public void shouldPrintFinalPositionOfEachRoverAfterExecutingCommands() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("5 5\n1 2 N\nMLR\n2 3 S\nRRR\n\n"));
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.processInputForRover(bufferedReader);
        assertEquals("1 3 N\n2 3 E\n", outContent.toString());
    }

    @Test
    public void shouldPrintErrorMessageForInvalidRoverCommand(){
        Rover rover = new Rover(new Position(new TestCoordinates(1,2), Orientation.North));
        rover.runCommands("MMK");
        String expectedOutput = "Unrecognized Command. Terminating execution of further" +
                " commands for this rover.";
        assertEquals(expectedOutput, outContent.toString());
    }

}
