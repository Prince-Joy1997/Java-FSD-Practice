package com.ust.books.service;

import com.ust.books.domain.Author;
import com.ust.books.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Author> findAuthorByName(String author);

    Book addBook(List<Book> booksList, Book book);

    Book findBookByTitle(List<Book> booksList, String name);
}
