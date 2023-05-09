package ru.sonyabeldy.springcourse.models;

import ru.sonyabeldy.springcourse.repositories.BookDelayRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.Timestamp;

@Entity
@Table(name = "bookDelay")
public class BookDelay {


    @Id
    @Column(name = "book_id")
    int bookId;

    @Column(name = "deadline")
    Timestamp deadline;

    public BookDelay() {

    }
    public BookDelay(int bookId, Timestamp deadline) {
        this.bookId = bookId;
        this.deadline = deadline;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }
}
