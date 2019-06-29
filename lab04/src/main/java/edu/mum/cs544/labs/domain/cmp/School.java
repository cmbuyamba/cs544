package edu.mum.cs544.labs.domain.cmp;

import edu.mum.cs544.labs.domain.amp2.Student;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    private Long id;
    private String name;
    @OneToMany
    @MapKey(name = "studentId")
    private Map<String, Student> students = new HashMap<>();
}
