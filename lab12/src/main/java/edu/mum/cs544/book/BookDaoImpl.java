package edu.mum.cs544.book;

import edu.mum.cs544.car.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao {
	public BookDaoImpl() {
		this.daoType= Book.class;
	}
}