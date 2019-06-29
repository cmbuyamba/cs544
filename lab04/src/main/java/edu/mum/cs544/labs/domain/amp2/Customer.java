package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private Long id;
    private String email;
    private String phone;
    private String customerNumber;
    @OneToMany
    private List<Reservation> reservations=new ArrayList<>();
}
