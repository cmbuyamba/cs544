package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends GenericDaoImpl<Car> implements CarDao {
	public CarDaoImpl() {
		this.daoType=Car.class;
	}
}