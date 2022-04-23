package com.pl.home.library.controllers;

import com.pl.home.library.entities.Book;
import com.pl.home.library.repositories.BookRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@Component(value = "bookList")
@Join(path = "/", to = "/views/book-list.jsf")
public class BookListController {
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
}
