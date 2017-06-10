package org.tw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tw.pojo.RoverData;

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

    @RequestMapping("/home")
    public String home() {
        return "Welcome to Mars Rover";
    }
}
