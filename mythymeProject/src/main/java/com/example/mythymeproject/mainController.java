package com.example.mythymeproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class mainController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/")
    String getAll(Model model) {
        model.addAttribute("books");
        return "main";
    }

    @GetMapping("/books")
    List<Books> FindBookByIsbn(@RequestParam(name = "isbn") String isbn/*Model model*/) {
//        model.addAttribute("books", bookRepo.findBooksByIsbn(isbn));
//        model.addAttribute("isbn", isbn);
        return bookRepo.findBooksByIsbn(isbn);
    }
}
