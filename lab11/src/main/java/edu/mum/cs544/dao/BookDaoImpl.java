package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.domain.Car;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao {
	public BookDaoImpl() {
		this.daoType= Book.class;
	}
}