package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    private Long id;
    private LocalDate date;
}
