package edu.mum.cs544.labs.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Command")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "orderid")
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<OrderLine> orderLines=new ArrayList<>();
}
