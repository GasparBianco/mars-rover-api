package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rover {

    @Id
    @GeneratedValue
    private int id;
    private int positionX;
    private int positionY;
    private int direction;
}
