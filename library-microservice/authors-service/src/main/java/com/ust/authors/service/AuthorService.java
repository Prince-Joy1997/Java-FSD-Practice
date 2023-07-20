package com.ust.authors.service;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;

import java.util.List;

public interface AuthorService {

    List<Book> findBooksByAuthor(String author);

    Author addAuthor(List<Author> list, Author author);

    Author getAuthorByName(List<Author> list, String name);
}
