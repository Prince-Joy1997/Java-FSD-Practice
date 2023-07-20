package com.ust.authors.service;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    public Author addAuthor(List<Author> list, Author author) {
        list.add(author);
        return author;
    }

    @Override
    public Author getAuthorByName(List<Author> list, String name) {
        return list.stream().filter(author -> author.getName().equals(name)).findFirst().orElseThrow();
    }
}

