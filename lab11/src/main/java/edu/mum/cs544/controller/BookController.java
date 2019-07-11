package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/book")
    public String root() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model){
        model.addAttribute("books",bookService.getAll());
        return "bookList";
    }

    @PostMapping("/books")
    public String add(Book book){
        bookService.add(book);
        return "redirect:/books";
    }

    @GetMapping("/books/add")
    public String addView(@ModelAttribute Book book, Model model){
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model){
        model.addAttribute("msg","Update");
        model.addAttribute("book", bookService.get(id));
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(Book book, @PathVariable int id){
        bookService.update(book);
        return "redirect:/books";
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable int id){
        bookService.delete(bookService.get(id));
        return "redirect:/books";
    }
}