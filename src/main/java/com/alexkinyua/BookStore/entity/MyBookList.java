package com.alexkinyua.BookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MyBooks")
@Getter
@Setter
@NoArgsConstructor
public class MyBookList {

    public MyBookList(int id, String title, String author, int price) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Id
    private int id;
    private String title;
    private String author;
    private int price;

}