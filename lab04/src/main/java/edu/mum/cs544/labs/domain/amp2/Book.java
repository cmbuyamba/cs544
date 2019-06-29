package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String ISBN;
    @ManyToOne
    @JoinColumn
    private Publisher publisher;
    @ManyToOne
    @JoinTable(name = "book_reservation")
    private Reservation reservation;
}
