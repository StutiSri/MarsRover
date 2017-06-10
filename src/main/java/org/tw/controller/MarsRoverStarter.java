package org.tw.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MarsRoverStarter {
    public static void main(String[] args) {
        SpringApplication.run(MarsRoverStarter.class, args);
       /* MarsRoverCommander marsRoverCommander = new MarsRoverCommander();
        marsRoverCommander.start();*/
    }
}
