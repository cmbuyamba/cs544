package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
