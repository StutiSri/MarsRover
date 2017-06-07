package org.tw.starter;

import org.tw.marsrover.MarsRoverCommander;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MarsRoverStarter {
    public static void main(String[] args) {
        MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.start();
    }
}
