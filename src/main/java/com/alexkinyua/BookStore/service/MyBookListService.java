package com.alexkinyua.BookStore.service;

import com.alexkinyua.BookStore.entity.MyBookList;
import com.alexkinyua.BookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    private MyBookRepository myBook;

    @Autowired
    public MyBookListService(MyBookRepository myBook) {
        this.myBook = myBook;
    }

    public void saveMyBook(MyBookList book){
        myBook.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBook.findAll();
    }

    public void deleteById(int id){
        myBook.deleteById(id);
    }
}
