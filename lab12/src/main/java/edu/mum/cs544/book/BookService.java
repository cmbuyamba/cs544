package edu.mum.cs544.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Resource
    private BookRepository repository;
    //private BookDao bookDao;
    
    public List<Book> getAll() {
        return repository.findAll();
    }

    public void add(Book book) {
        repository.save(book);
    }

    public Book get(int id) {
        return repository.getOne(id);
    }

    public void update(Book book) {
        repository.save(book);
    }

    public void delete(Book book) {
        repository.delete(book);
    }
}