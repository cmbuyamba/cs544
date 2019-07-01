package edu.mum.cs544.labs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;
    @ManyToOne
    private Product product;
}
