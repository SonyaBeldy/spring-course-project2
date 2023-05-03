package ru.sonyabeldy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sonyabeldy.springcourse.services.BooksService;
import ru.sonyabeldy.springcourse.services.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {

    public final PeopleService peopleService;
    public final BooksService booksService;
    public PeopleController(PeopleService peopleService, BooksService booksService) {
        this.peopleService = peopleService;
        this.booksService = booksService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("person", peopleService.findById(id));
        model.addAttribute("books", booksService.findByOwner(peopleService.findById(id)));
        return "people/show";
    }
}
