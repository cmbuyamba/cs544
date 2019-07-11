package edu.mum.cs544.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/book")
    public String root() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @PostMapping("/books")
    public String add(@Valid Book book, BindingResult result,
                      RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            flash.addFlashAttribute("book", book);
            return "redirect:/books/add";
        } else {
            bookService.add(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/books/add")
    public String addView(@ModelAttribute Book book, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("msg", "Update");
        model.addAttribute("book", bookService.get(id));
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(@Valid Book book, BindingResult result,
                         @PathVariable int id, RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            flash.addFlashAttribute("book", book);
            return "redirect:/books/{id}";
        } else {
            bookService.update(book);
            return "redirect:/books";
        }
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable int id) {
        bookService.delete(bookService.get(id));
        return "redirect:/books";
    }
}