package edu.mum.cs544.labs.domain.amp2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private String studentId;
    @Column(nullable = true, length = 32)
    private String name;
    @Column(nullable = true, length = 32)
    private String email;
    @Column(nullable = true, length = 16)
    private String password;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();
}
