package org.tw.marsrover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by stutis on 6/5/17.
 */
public class MarsRoverStarter {
    private Plateau plateau;

    public MarsRoverStarter(Plateau plateau) {

        this.plateau = plateau;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MarsRoverStarter marsRoverStarter;
        try {
            String line = bufferedReader.readLine();
            String[] upperCoordinateLimits = line.split(" ");
            Plateau plateau = new Plateau(Integer.parseInt(upperCoordinateLimits[0]), Integer.parseInt
                    (upperCoordinateLimits[1]));
            marsRoverStarter = new MarsRoverStarter(plateau);
            marsRoverStarter.processInputForRover(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processInputForRover(BufferedReader bufferedReader) throws IOException {
        String line;
        String[] roverAttributes;
        line = bufferedReader.readLine();
        while (line.length() != 0) {
            Rover rover = getRover(line);
            sendCommandsToRover(bufferedReader.readLine(), rover);
            line = bufferedReader.readLine();
        }
    }

    public Rover getRover(String line) {
        String[] roverAttributes;
        roverAttributes = line.split(" ");
        Coordinates coordinates = new Coordinates(Integer.parseInt(roverAttributes[0]), Integer
                .parseInt(roverAttributes[1]));
        Orientation orientation = getOrientation(roverAttributes[2]);
        return new Rover(coordinates, orientation, plateau);
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
        System.out.println(rover);
    }
}
