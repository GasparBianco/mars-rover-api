package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoverService {

    @Autowired
    private RoverRepository roverRepository;
    public Rover input(String command) throws InterruptedException {
        Rover rover = roverRepository.findById(1L).orElseThrow();
        command = command.toLowerCase();

        for (char c : command.toCharArray()) {
            if (c != 'l' && c != 'f' && c != 'r') {
                throw new IllegalArgumentException("Caracter no permitido: " + c);
            }
            this.executeCommand(c, rover);
        }
        return roverRepository.save(rover);
    }
    private void executeCommand(Character c, Rover rover) throws InterruptedException {
        switch (c) {
            case 'l' -> rover.setDirection((rover.getDirection() + 3) % 4);
            case 'r' -> rover.setDirection((rover.getDirection() + 1) % 4);
            case 'f' -> this.movement(rover);
        }
    }
    private void movement(Rover rover){
        int north = 3;
        int east = 0;
        int south = 1;
        int west = 2;

        if (rover.getDirection() == north){
            rover.setPositionY(rover.getPositionY() - 1);
        } else if (rover.getDirection() == south) {
            rover.setPositionY(rover.getPositionY() + 1);
        }else if (rover.getDirection() == east) {
            rover.setPositionX(rover.getPositionX() + 1);
        }else if (rover.getDirection() == west) {
            rover.setPositionX(rover.getPositionX() - 1);
        }

    }

    public Rover getRover() {
        return roverRepository.findById(1L).orElseGet(() -> {
            Rover rover = new Rover();
            rover.setPositionY(0);
            rover.setPositionX(0);
            rover.setDirection(0);
            return roverRepository.save(rover);
        });
    }

    public Rover resetRover() {
        Rover rover = roverRepository.findById(1L).orElseThrow();
        rover.setDirection(0);
        rover.setPositionX(0);
        rover.setPositionY(0);
        return roverRepository.save(rover);
    }
}
