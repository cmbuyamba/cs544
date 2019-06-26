In this lab we learned how to create en entity and do the mapping with the DB

Lab 02 part 1 // package edu.mum.cs544.book
1. To make Book class as an entity we performed following steps
    Annotate the class definition with @Entity
    Annotate id field with @Id to make it the ID of the entity and generated value with @GeneratedValue(strategy = GenerationType.IDENTITY)
    Make ISBN as unique by using constraints annotation
    Create setters and getters for each field
    Create constructors for the entity
2. To test we create AppBook with main method
    Create Entity manager factory
    Create Entity manager from the factory
    Open transaction
    invoke crud method (persist, merge, remove or createQuery)
    Commit transaction
    CLose Entity manager

Lab 02 part 2 // package edu.mum.cs544.simpsons
1. To do this lab we performed following steps
    Create database in MySQL server
    Rename all tables as this to respect the standard courses => course, grades => grade, students => student and teachers => teacher
    Create entities using IntelliJ JPA tools

2. To test we create App with main method
    Create Entity manager factory
    Create Entity manager from the factory
    Open transaction
    invoke crud method (persist, merge, remove or createQuery)
    Commit transaction
    CLose Entity manager