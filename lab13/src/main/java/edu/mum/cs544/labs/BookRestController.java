package edu.mum.cs544.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public List<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/books")
    public RedirectView add(@RequestBody Book book) {
        service.add(book);
        return new RedirectView("/books/" + book.getId());
    }

    @PutMapping("/books/{id}")
    public void update(@RequestBody Book book) {
        service.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
