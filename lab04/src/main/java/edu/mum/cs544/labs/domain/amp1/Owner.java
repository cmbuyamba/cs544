package edu.mum.cs544.labs.domain.amp1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "owner")
    private List<Car> cars=new ArrayList<>();

    public Owner() {
    }

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean addCar(Car car){
        if(cars.add(car)){
            car.setOwner(this);
            return true;
        }
        return false;
    }

    public boolean removeCar(Car car){
        if(cars.remove(car)){
            car.setOwner(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}