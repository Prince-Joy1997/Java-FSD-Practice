package com.ust.authors.controller;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import com.ust.authors.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/library")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    private RestTemplate restTemplate;

    public AuthorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static List<Author> list = new ArrayList<>();

    // POST /authors
    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(Author author) {
        return ResponseEntity.ok(authorService.addAuthor(list, author));
    }

    // GET  /authors/{name}
    @GetMapping("/authors/{name}")
    public ResponseEntity<Author> getAuthorByName(@PathVariable String name) {
        var item = authorService.getAuthorByName(list, name);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(item);
    }

    // GET  /authors/{name}/books
    @GetMapping("/authors/{name}/books")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String name) {

        ResponseEntity<Book[]> response = restTemplate.getForEntity("http://localhost:8100/books/books/{author}", Book[].class, name);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(Arrays.stream(response.getBody()).toList());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

