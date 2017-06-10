package org.tw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tw.marsrover.MarsRoverCommander;
import org.tw.pojo.RoverData;
import org.tw.pojo.RoverPosition;

@RestController
public class MarsRoverRequestController {
    @RequestMapping("/")
    public ResponseEntity<RoverData> get() {

        RoverData roverData = new RoverData();
        roverData.setPlateauUpperCoordinates("5 5");
        roverData.setRoverCoordinate("1 2 E");
        roverData.setCommands("M");
        return new ResponseEntity<RoverData>(roverData, HttpStatus.OK);
    }

    @RequestMapping(value="/executeCommands",method = RequestMethod.POST)
    public ResponseEntity<RoverPosition> executeCommand(@RequestBody RoverData roverData) {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setPosition(new MarsRoverCommander().calculateNewRoverPosition(roverData));
        return new ResponseEntity<RoverPosition>(roverPosition, HttpStatus.OK);
    }
}
