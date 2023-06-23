package com.alexkinyua.BookStore.controller;

import com.alexkinyua.BookStore.service.MyBookListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MyBookListController {

    private final MyBookListService myBookListService;


    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }
}