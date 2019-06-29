package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
