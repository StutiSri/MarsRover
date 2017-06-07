package org.tw.marsrover;

import org.tw.exception.IllegalCoordinateException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarsRoverStarter {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MarsRoverStarter marsRoverStarter = new MarsRoverStarter();
        marsRoverStarter.processInputForRover(bufferedReader);
    }

    public static Plateau getPlateau(String line) {
        String[] upperCoordinateLimits = line.split(" ");
        return new Plateau(Integer.parseInt(upperCoordinateLimits[0]), Integer.parseInt
                (upperCoordinateLimits[1]));
    }

    public void processInputForRover(BufferedReader bufferedReader) {
        try {
            String line = bufferedReader.readLine();
            Plateau plateau = getPlateau(line);
            line = bufferedReader.readLine();
            while (line.length() != 0) {
                Rover rover = getRover(line, plateau);
                sendCommandsToRover(bufferedReader.readLine(), rover);
                System.out.println(rover);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rover getRover(String line, Plateau plateau) {
        String[] roverAttributes;
        roverAttributes = line.split(" ");
        int xCoordinate = Integer.parseInt(roverAttributes[0]);
        int yCoordinate = Integer.parseInt(roverAttributes[1]);
        validateCoordinates(xCoordinate, yCoordinate,plateau);
        Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
        Orientation orientation = getOrientation(roverAttributes[2]);
        return new Rover(coordinates, orientation, plateau);
    }

    private void validateCoordinates(int xCoordinate, int yCoordinate, Plateau plateau) {
        if(xCoordinate < 0 || yCoordinate < 0)
            throw new IllegalCoordinateException();
        if(xCoordinate > plateau.getUpperCoordinateLimits().getX() || yCoordinate > plateau.getUpperCoordinateLimits().getY())
            throw new IllegalCoordinateException();
    }

    public Orientation getOrientation(String roverAttribute) {
        if (roverAttribute.equals("N"))
            return Orientation.N;
        if (roverAttribute.equals("S"))
            return Orientation.S;
        if (roverAttribute.equals("W"))
            return Orientation.W;
        if (roverAttribute.equals("E"))
            return Orientation.E;
        return null;
    }

    public void sendCommandsToRover(String setOfCommands, Rover rover) {
        char[] commands = setOfCommands.toCharArray();
        for (char command : commands)
            rover.execute(command);
    }
}
