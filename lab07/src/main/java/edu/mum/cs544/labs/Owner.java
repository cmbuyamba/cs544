package edu.mum.cs544.labs;

import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Fetch(FetchMode.SUBSELECT)
    //@BatchSize(size = 50)
    //@LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Pet> pets = new ArrayList<>();

    public Owner() {
    }

    public Owner(String name) {
        super();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addPet(Pet pet) {
        if (pets.add(pet)) {
           // pet.setOwner(this);
            return true;
        }
        return false;
    }

    public boolean removePet(Pet pet) {
        if (pets.remove(pet)) {
            //pet.setOwner(null);
            return true;
        }
        return false;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
