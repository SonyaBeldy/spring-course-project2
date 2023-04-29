package ru.sonyabeldy.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sonyabeldy.springcourse.config.SpringConfig;
import ru.sonyabeldy.springcourse.models.Book;
import ru.sonyabeldy.springcourse.models.Person;
import ru.sonyabeldy.springcourse.services.PeopleService;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main {


//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        PeopleService peopleService = applicationContext.getBean("peopleService", PeopleService.class);
//        Person person = peopleService.findById(3);
////        person.getBooks();
//        System.out.println(person);
//
//        person = new Person();
//        person.setName("Lala");
//
//        person.setDateOfBirth(new GregorianCalendar(1999, Calendar.JULY, 21).getTime());
//        peopleService.save(person);
//    }
}
