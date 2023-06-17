package com.alexkinyua.BookStore.controller;

import com.alexkinyua.BookStore.entity.Book;
import com.alexkinyua.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book>list = service.getAllBooks();
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }
}
