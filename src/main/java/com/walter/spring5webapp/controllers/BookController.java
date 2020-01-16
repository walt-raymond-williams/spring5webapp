package com.walter.spring5webapp.controllers;

import com.walter.spring5webapp.model.respositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books"; //view name in thymeleaf
    }
}
