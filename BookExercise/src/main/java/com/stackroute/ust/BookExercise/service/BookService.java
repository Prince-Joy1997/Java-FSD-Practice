package com.stackroute.ust.BookExercise.service;

import com.stackroute.ust.BookExercise.model.Book;
import com.stackroute.ust.BookExercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllByLanguage(String language) {
        return bookRepository.findAllByLanguage(language);
    }
}
