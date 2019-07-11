package edu.mum.cs544.book;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericDao<T> {

	public abstract List<T> getAll();

	public abstract void add(T t);

	public abstract T get(int id);

	public abstract void update(T T);

	public abstract void delete(int id);

}