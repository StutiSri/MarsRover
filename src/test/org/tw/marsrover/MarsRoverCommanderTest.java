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
    public void shouldTurnRoverAtCommandL() {
        TestRover rover = new TestRover(new Coordinates(1, 2), Orientation.East);
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.sendCommandsToRover("L", rover);
        TestRover expected = new TestRover(new Coordinates(1, 2), Orientation.North);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldTurnRoverAtCommandR() {
        TestRover rover = new TestRover(new Coordinates(3, 2), Orientation.South);
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.sendCommandsToRover("R", rover);
        TestRover expected = new TestRover(new Coordinates(3, 2), Orientation.West);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldMoveRoverInSameDirectionAtCommandM() {
        TestRover rover = new TestRover(new Coordinates(0, 0), Orientation.East);
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.sendCommandsToRover("M", rover);
        TestRover expected = new TestRover(new Coordinates(1, 0), Orientation.East);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldMoveRoverAsPerTheCommand() {
        TestRover rover = new TestRover(new Coordinates(1, 2), Orientation.North);
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.sendCommandsToRover("LMLMLMLMM", rover);
        TestRover expected = new TestRover(new Coordinates(1, 3), Orientation.North);
        assertEquals(expected, rover);
    }

    @Test
    public void shouldReturnOrientationWithStringInputForOrientation() {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        assertEquals(Orientation.East, marsRoverCommander.getOrientation("E"));
    }

    @Test
    public void shouldCreateRoverFromStringInput() throws IOException {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputPosition = "1 2 N";
        TestRover expected = new TestRover(new Coordinates(1,2), Orientation.North);
        assertEquals(expected, marsRoverCommander.getRover(inputPosition, new Plateau(5,5)));
    }

    @Test
    public void shouldCreatePlateauFromStringInput(){
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        String inputUpperCoordinates = "5 5";
        TestPlateau expected = new TestPlateau(5,5);
        assertEquals(expected, marsRoverCommander.getPlateau(inputUpperCoordinates));
    }

    @Test
    public void shouldPrintFinalPositionOfEachRoverAfterExecutingCommands() throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new StringReader("5 5\n1 2 N\nMLR\n2 3 S\nRRR\n\n"));
       MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
       marsRoverCommander.processInputForRover(bufferedReader);
       assertEquals("1 3 N\n2 3 E\n", outContent.toString());
    }

    @Test(expected = IllegalCoordinateException.class)
    public void shouldThrowIllegalCoordinateExceptionForCoordinateValueLessThanZero(){
        BufferedReader bufferedReader = new BufferedReader(new StringReader("5 5\n-1 2 N\n"));
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.processInputForRover(bufferedReader);
    }

    @Test(expected = IllegalCoordinateException.class)
    public void shouldThrowIllegalCoordinateExceptionForCoordinateValueGreaterThanPlateauUpperBounds(){
        BufferedReader bufferedReader = new BufferedReader(new StringReader("5 5\n1 6 N\n"));
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.processInputForRover(bufferedReader);
    }
}
