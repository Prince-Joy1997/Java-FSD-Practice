package com.stackroute.ust.BookExercise.controller;

import com.stackroute.ust.BookExercise.model.Book;
import com.stackroute.ust.BookExercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
    }

    @GetMapping("/{language}")
    public ResponseEntity<List<Book>> findBookByLanguage(@PathVariable String language){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllByLanguage(language));
    }
}
