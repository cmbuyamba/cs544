package edu.mum.cs544.labs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        LocalDateTime dateTime = LocalDateTime.now();
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        for (int x = 0; x < 100000; x++) {
            Owner owner = new Owner("Frank" + x);

            for (int y = 0; y < 10; y++) {
                owner.addPet(new Pet("Garfield" + x + "-" + y));
            }

            em.persist(owner);
        }

        em.getTransaction().commit();
        em.close();
        System.out.println(dateTime);
        System.out.println(LocalDateTime.now());
    }

}
