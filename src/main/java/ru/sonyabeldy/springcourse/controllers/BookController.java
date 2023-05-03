package ru.sonyabeldy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sonyabeldy.springcourse.models.Book;
import ru.sonyabeldy.springcourse.models.Person;
import ru.sonyabeldy.springcourse.services.BooksService;
import ru.sonyabeldy.springcourse.services.PeopleService;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BooksService booksService;
    private final PeopleService peopleService;

    public BookController(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable int id, @ModelAttribute("person") Person person, Model model) {
        model.addAttribute("book", booksService.findById(id));
        model.addAttribute("people", peopleService.findAll());

        model.addAttribute("owner", Optional.ofNullable(booksService.findById(id).getOwner()));
        return "books/show";
    }

    @PatchMapping("/{id}")
    public String setOwner(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        booksService.setOwner(id, person);
        return "redirect:/books/{id}";
    }

    @PatchMapping("/{id}/remove")
    public String removeOwner(@PathVariable("id") int id) {
        booksService.removeOwner(id);
        return "redirect:/books/{id}";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") Book book) {
        booksService.save(book);
        return "redirect:/books";
    }

}
