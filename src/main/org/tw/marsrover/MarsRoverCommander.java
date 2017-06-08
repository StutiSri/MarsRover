package org.tw.marsrover;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarsRoverCommander {

    public void start() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        processInputForRover(bufferedReader);
    }


    public void processInputForRover(BufferedReader bufferedReader) {
        try {
            String line = bufferedReader.readLine();
            BoundaryLimits boundaryLimits = getBoundaryLimits(line);
            line = bufferedReader.readLine();
            while (line.length() != 0) {
                Rover rover = getRover(line, boundaryLimits);
                sendCommandsToRover(bufferedReader.readLine(), rover);
                System.out.println(rover);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BoundaryLimits getBoundaryLimits(String line) {
        String[] upperCoordinateLimits = line.split(" ");
        return new BoundaryLimits(Integer.parseInt(upperCoordinateLimits[0]), 0);
    }

    public Rover getRover(String line, BoundaryLimits boundaryLimits) {
        String[] roverAttributes;
        roverAttributes = line.split(" ");
        Coordinates coordinates = new Coordinates(Integer.parseInt(roverAttributes[0]), Integer.parseInt(roverAttributes[1]),boundaryLimits);
        Orientation orientation = Orientation.fromString(roverAttributes[2]);
        return new Rover(new Position(coordinates, orientation));
    }


    public void sendCommandsToRover(String setOfCommands, Rover rover) {
        rover.runCommands(setOfCommands);
    }

}
