package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public class MarsRover {
    private Plateau plateau;

    public MarsRover(Plateau plateau) {

        this.plateau = plateau;
    }

    public void sendCommandsToRover(String setOfCommands, Rover rover) {
        char[] commands = setOfCommands.toCharArray();
        for(char command : commands)
            rover.execute(command);
    }
}
