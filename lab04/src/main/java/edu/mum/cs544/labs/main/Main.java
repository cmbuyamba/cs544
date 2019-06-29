package edu.mum.cs544.labs.main;

import edu.mum.cs544.labs.domain.amp1.Car;
import edu.mum.cs544.labs.domain.amp1.Owner;
import edu.mum.cs544.labs.domain.cmp.Employee2;
import edu.mum.cs544.labs.domain.cmp.Flight;
import edu.mum.cs544.labs.domain.cmp.Laptop;
import edu.mum.cs544.labs.domain.cmp.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory cs544 = Persistence.createEntityManagerFactory("cs544");
        EntityManager entityManager = cs544.createEntityManager();
        entityManager.getTransaction().begin();

        Owner owner = new Owner("Celestin Mbuyamba", "1000 4th N, Fairfiled 52557, IA");

        Car toyota = new Car("Toyota", "2019", 25000);
        toyota.setOwner(owner);
        entityManager.persist(toyota);
        Car mazda = new Car("Mazda", "2016", 30000);
        mazda.setOwner(owner);
        entityManager.persist(mazda);

        entityManager.getTransaction().commit();
        entityManager.close();

        Employee2 employee2 = new Employee2("Celestin", "Mbuyamba", 15000);
        Laptop hp = new Laptop(500, "HP");
        Laptop lenovo = new Laptop(1000, "Lenovo");
        employee2.addLaptop(hp);
        employee2.addLaptop(lenovo);

        entityManager = cs544.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee2);
        employee2.removeLaptop(lenovo);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = cs544.createEntityManager();
        entityManager.getTransaction().begin();
        Flight flight = new Flight("FIH", "ORD", 300, 200, LocalDate.of(2019, 01, 7), LocalTime.of(21, 30), LocalTime.of(14, 30));
        flight.addPassenger(new Passenger("Celestin Mbuyamba", 23,2));
        entityManager.persist(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
