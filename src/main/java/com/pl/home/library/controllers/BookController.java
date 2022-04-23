package com.pl.home.library.controllers;


import com.pl.home.library.entities.Book;
import com.pl.home.library.repositories.BookRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.SessionScoped;

@SessionScoped
@Component(value = "bookController")
@Join(path = "/book", to = "/views/book-form.jsf")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    private Book book = new Book();

    public String save() {
		bookRepository.save(book);
		book = new Book();
        return "/views/book-list.xhtml?faces-redirect=true";
    }

    public Book getBook() {
        return book;
    }

}
