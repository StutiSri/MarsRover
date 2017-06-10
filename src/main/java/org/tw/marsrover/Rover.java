package org.tw.marsrover;

import static org.tw.marsrover.CommandType.*;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public void runCommands(String setOfCommands) {
        CommandType commandType;
        for(char command : setOfCommands.toCharArray()) {
            commandType = fromCharacter(command);
            if(commandType == null || execute(commandType) == 0)
                break;
        }
    }

    public int execute(CommandType commandType){
        switch (commandType) {
            case Move:
                if(position.move() == null) {
                    System.out.println("Invalid Move. Rover Going out of Boundary. Terminating execution of " +
                            "further" +
                            " commands for this rover.");
                    return 0;
                }
                return 1;
            case Left:
                position.turnLeft();
                return 1;
            case Right:
                position.turnRight();
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }

    public Position getPosition() {
        return position;
    }
}
