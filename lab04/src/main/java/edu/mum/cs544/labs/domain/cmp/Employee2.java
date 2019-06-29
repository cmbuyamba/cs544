package edu.mum.cs544.labs.domain.cmp;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee2 {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private double salary;
    @OneToMany(mappedBy = "employee2",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Laptop> laptopSet = new HashSet<>();

    public Employee2() {
    }

    public Employee2(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public boolean addLaptop(Laptop laptop) {
        if (laptopSet.add(laptop)) {
            laptop.setEmployee2(this);
            return true;
        }
        return false;
    }

    public boolean removeLaptop(Laptop laptop) {
        if (laptopSet.remove(laptop)) {
            laptop.setEmployee2(null);
            return true;
        }
        return false;
    }
}
