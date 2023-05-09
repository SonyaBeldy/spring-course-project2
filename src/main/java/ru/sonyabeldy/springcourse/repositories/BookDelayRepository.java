package ru.sonyabeldy.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sonyabeldy.springcourse.models.Book;
import ru.sonyabeldy.springcourse.models.BookDelay;

@Repository
public interface BookDelayRepository extends JpaRepository<BookDelay, Integer> {
}
