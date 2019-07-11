package edu.mum.cs544.book;

import edu.mum.cs544.car.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
