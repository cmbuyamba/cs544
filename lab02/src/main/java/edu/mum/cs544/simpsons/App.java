package edu.mum.cs544.simpsons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //Create Entity manager factory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("simpsons");

        //Open a EntityManager
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //Retrieve all students from the database and display their names
        List<Student> students = entityManager.createQuery("from Student", Student.class).getResultList();
        entityManager.getTransaction().commit();
        students.forEach(System.out::println);

        //Close the EntityManager
        entityManager.close();

        //Open a EntityManager
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //Add an extra student to the database (you can choose his / her name)
        Student student = new Student();
        student.setEmail("cmbuyamba@mum.edu");
        student.setId(987054);
        student.setName("Celestin Mbuyamba");
        student.setPassword("123456");
        try {
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
        }

        //Close the EntityManager
        entityManager.close();

        //Open a EntityManager
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //Retrieve all students again from the database and display their names
        students = entityManager.createQuery("from Student", Student.class).getResultList();
        entityManager.getTransaction().commit();
        students.forEach(System.out::println);

        //Close the EntityManager
        entityManager.close();
    }
}
