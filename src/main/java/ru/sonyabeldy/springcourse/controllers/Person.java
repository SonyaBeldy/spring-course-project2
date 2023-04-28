package ru.sonyabeldy.springcourse.controllers;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yy")
    private Date year;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;
    public Person() {

    }

    public Person(int id, String name, Date year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getYear() {
        return year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", books=" + books +
                '}';
    }
}
