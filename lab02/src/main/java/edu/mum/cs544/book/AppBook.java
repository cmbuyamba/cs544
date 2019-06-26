package edu.mum.cs544.book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class AppBook {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");

        //Open a EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Create 3 books save them to the database
        Book java = new Book("Modern Java Programming", "1298-6325-8963", "Celestin Mbuyamba", 32.00, LocalDate.of(2019, 10, 23));
        Book sql = new Book("Mastering SQL Queries", "1298-6325-8964", "Celestin Mbuyamba", 40.00, LocalDate.of(2015, 1, 15));
        Book spring = new Book("Srping Boot In Action", "1298-6325-5694", "Celestin Mbuyamba", 25.00, LocalDate.of(2017, 8, 7));
        em.persist(java);
        em.persist(sql);
        em.persist(spring);
        em.getTransaction().commit();
        //Close the EntityManager
        em.close();

        //Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //Retrieve all books and output them to the console
        List<Book> books = em.createQuery("from Book", Book.class).getResultList();
        em.getTransaction().commit();
        //Close the EntityManager
        em.close();
        books.forEach(System.out::println);

        //Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //Retrieve all books from the database, and then:
        books = em.createQuery("from Book", Book.class).getResultList();
        sql = books.get(1); //Change the title and price of one book
        sql.setPrice(60.00);
        sql.setTitle("Mastering MS SQL Queries");
        em.merge(sql);
        //Use em.remove() to delete a different book (not the one that was just updated)
        em.remove(books.get(0));
        em.getTransaction().commit();
        //Close the EntityManager
        em.close();

        //Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //Retrieve all books and output them to the console
        books = em.createQuery("from Book", Book.class).getResultList();
        em.getTransaction().commit();
        //Close the EntityManager
        em.close();
        books.forEach(System.out::println);
    }
}