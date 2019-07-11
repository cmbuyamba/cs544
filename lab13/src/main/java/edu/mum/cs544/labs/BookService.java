package edu.mum.cs544.labs;

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
        return repository.findById(id).orElse(new Book());
    }

    public void update(Book book) {
        repository.save(book);
    }

    public void delete(int id) {

        repository.delete(repository.getOne(id));
    }
}