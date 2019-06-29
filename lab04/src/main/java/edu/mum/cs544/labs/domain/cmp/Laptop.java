package edu.mum.cs544.labs.domain.cmp;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private Long id;
    private double price;
    private String brand;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_laptop")
    private Employee2 employee2;

    public Laptop() {
    }

    public Laptop(double price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    public void setEmployee2(Employee2 employee2) {
        this.employee2 = employee2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.price, price) == 0 &&
                Objects.equals(id, laptop.id) &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(employee2, laptop.employee2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, brand, employee2);
    }
}
