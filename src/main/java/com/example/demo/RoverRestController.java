package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping()
public class RoverRestController {
    @Autowired
    RoverService roverService;
    @CrossOrigin(origins = "*" )
    @GetMapping(path = "/getPosition")
    public Rover obtenerPosicion(){
        return roverService.getRover();
    }

    @CrossOrigin(origins = "*" )
    @GetMapping(path = "/input/{command}")
    public Rover command(@PathVariable String command) throws InterruptedException {
        return roverService.input(command);
    }
    @CrossOrigin(origins = "*" )
    @GetMapping(path = "/resetPosition")
    public Rover reset() throws InterruptedException {
        return roverService.resetRover();
    }
}
