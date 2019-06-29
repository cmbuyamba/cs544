package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private double salary;
    @ManyToOne
    private Department department;
    @ManyToOne
    @JoinColumn
    private Office office;
}
