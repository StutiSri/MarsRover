package org.tw.marsrover;

public enum CommandType {
    Left("L"), Right("R"), Move("M");

    public String parameterName;

    CommandType(String parameterName) {
        this.parameterName = parameterName;
    }

    public static CommandType fromCharacter(char command) {
        for (CommandType commandType : CommandType.values()) {
            if (command == commandType.parameterName.charAt(0))
                return commandType;
        }
        System.out.print("Unrecognized Command. Terminating execution of further" +
                " commands for this rover.");
        return null;
    }
}
