package ru.sonyabeldy.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sonyabeldy.springcourse.models.Book;
import ru.sonyabeldy.springcourse.models.Person;
import ru.sonyabeldy.springcourse.repositories.BooksRepository;
import ru.sonyabeldy.springcourse.repositories.PeopleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }
    public Book findById(int id) {
        return booksRepository.findById(id).orElse(null);
    }
}
