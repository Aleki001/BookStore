package com.alexkinyua.BookStore.service;

import com.alexkinyua.BookStore.entity.Book;
import com.alexkinyua.BookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bRepo;

    public void save(Book b){
        bRepo.save(b);
    }

    public List<Book> getAllBooks(){
        return bRepo.findAll();
    }

    public Book getBookById(int id){
        return bRepo.findById(id).get();
    }

    public void deleteById(int id){
        bRepo.deleteById(id);
    }
}