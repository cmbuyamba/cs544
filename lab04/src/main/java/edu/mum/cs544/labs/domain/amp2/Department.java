package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees=new ArrayList<>();
}
