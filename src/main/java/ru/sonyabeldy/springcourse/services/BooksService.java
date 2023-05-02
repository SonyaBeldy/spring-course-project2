package ru.sonyabeldy.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sonyabeldy.springcourse.models.Book;
import ru.sonyabeldy.springcourse.models.Person;
import ru.sonyabeldy.springcourse.repositories.BooksRepository;
import ru.sonyabeldy.springcourse.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void removeOwner(int bookId) {
        Optional<Book> book = booksRepository.findById(bookId);
        if (book.isPresent()) {
            book.get().setOwner(null);
            booksRepository.save(book.get());
        }
    }

    public Book findById(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Transactional
    public void setOwner(int bookId, Person person) {
        Optional<Book> book = booksRepository.findById(bookId);
        if (book.isPresent()) {
            book.get().setOwner(person);
            booksRepository.save(book.get());
        }
    }
}
