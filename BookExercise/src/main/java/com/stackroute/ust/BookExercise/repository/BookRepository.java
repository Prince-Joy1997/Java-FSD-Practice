package com.stackroute.ust.BookExercise.repository;

import com.stackroute.ust.BookExercise.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findAllByLanguage(String language);
}
