package com.alexkinyua.BookStore.boot;

import com.alexkinyua.BookStore.entity.Book;
import com.alexkinyua.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private BookRepository bookRepository;

    @Autowired
    public void BookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void run(String... args) throws Exception {

        //BOOKS TEST DATA
        Book book1 = new Book();
        book1.setAuthor("George Haman");
        book1.setTitle("The Broken heart");
        book1.setPrice(1300);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setAuthor("Scott Wales");
        book2.setTitle("The Mafia Boss");
        book2.setPrice(2500);
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setAuthor("Ken Wanjohi");
        book3.setTitle("Goat Matata");
        book3.setPrice(300);
        bookRepository.save(book3);



    }
}
