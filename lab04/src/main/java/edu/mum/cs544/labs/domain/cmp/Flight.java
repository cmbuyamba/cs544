package edu.mum.cs544.labs.domain.cmp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String origin;
    private String destination;
    private int numSeats;
    private int passengersOnBoard;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();

    public Flight() {
    }

    public Flight(String origin, String destination, int numSeats, int passengersOnBoard, LocalDate flightDate, LocalTime departureTime, LocalTime arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.numSeats = numSeats;
        this.passengersOnBoard = passengersOnBoard;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.add(passenger)) {
            return true;
        }
        return false;
    }

    public boolean removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            return true;
        }
        return false;
    }
}
