package ru.sonyabeldy.springcourse.controllers;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sonyabeldy.springcourse.services.BooksService;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }

}
