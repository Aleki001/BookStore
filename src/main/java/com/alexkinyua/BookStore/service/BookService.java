package com.alexkinyua.BookStore.service;

import com.alexkinyua.BookStore.entity.Book;
import com.alexkinyua.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;
    public void save(Book b){
        bRepo.save(b);
    }

    public List<Book> getAllBooks(){
        return bRepo.findAll();
    }
}
