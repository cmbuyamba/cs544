package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends GenericDao<Book> {

}