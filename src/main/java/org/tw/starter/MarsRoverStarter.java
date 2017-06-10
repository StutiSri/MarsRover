package org.tw.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.tw.marsrover.MarsRoverCommander;

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
