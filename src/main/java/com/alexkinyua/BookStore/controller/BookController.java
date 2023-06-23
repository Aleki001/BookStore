package com.alexkinyua.BookStore.controller;

import com.alexkinyua.BookStore.entity.Book;
import com.alexkinyua.BookStore.entity.MyBookList;
import com.alexkinyua.BookStore.service.BookService;
import com.alexkinyua.BookStore.service.MyBookListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private final MyBookListService myBookListService;

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
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getTitle(), b.getAuthor(), b.getPrice());
        myBookListService.saveMyBook(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }
}