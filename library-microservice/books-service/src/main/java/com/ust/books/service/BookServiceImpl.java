package com.ust.books.service;

import com.ust.books.domain.Author;
import com.ust.books.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements  BookService{
    @Override
    public Optional<Author> findAuthorByName(String author) {
        return null;
    }

    @Override
    public Book addBook(List<Book> booksList, Book book) {
        booksList.add(book);
        return book;
    }

    @Override
    public Book findBookByTitle(List<Book> booksList, String name) {
        return booksList.stream()
                .filter(author -> author.getTitle().equals(name))
                .findFirst()
                .orElse(null);
    }
}
