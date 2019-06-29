package edu.mum.cs544.labs.domain.cmp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int row;
    private int seat;

    public Passenger() {
    }

    public Passenger(String name, int row, int seat) {
        this.name = name;
        this.row = row;
        this.seat = seat;
    }
}
