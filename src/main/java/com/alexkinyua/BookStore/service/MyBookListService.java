package com.alexkinyua.BookStore.service;

import com.alexkinyua.BookStore.entity.MyBookList;
import com.alexkinyua.BookStore.repository.MyBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyBookListService {

    private final MyBookRepository myBook;

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