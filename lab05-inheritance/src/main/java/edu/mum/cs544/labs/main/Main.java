package edu.mum.cs544.labs.main;

import edu.mum.cs544.labs.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory cs544 = Persistence.createEntityManagerFactory("cs544");
        EntityManager entityManager = cs544.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Customer());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
