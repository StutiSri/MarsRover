package org.tw.marsrover;


public enum Orientation {
    North("N") {
        public String toString() {
            return "N";
        }
    }, East("E"){
        public String toString() {
            return "E";
        }
    }, West("W"){
        public String toString() {
            return "W";
        }
    }, South("S"){
        public String toString() {
            return "S";
        }
    };
    private String parameter;

    Orientation(String parameter){
        this.parameter = parameter;
    }

    static {
        North.left = West;
        West.left = South;
        South.left = East;
        East.left = North;

        North.right = East;
        East.right = South;
        South.right = West;
        West.right = North;

    }

    Orientation left;
    Orientation right;

    public static Orientation fromString(String inputOrientation){
        for(Orientation orientation : Orientation.values()){
            if(inputOrientation.equals(orientation.parameter))
                return orientation;
        }
        System.out.println("Incorrect Orientation Provided. Accepted Inputs : N, W, E, S.\n" +
                "Skipping execution of rover commands.");
        return null;
    }

}
