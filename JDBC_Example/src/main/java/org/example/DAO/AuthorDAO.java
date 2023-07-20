package org.example.DAO;

import org.example.DTO.Author;

import java.util.List;

public interface AuthorDAO {

    int create(Author author);

    Author read(int authorId);
    List<Author> readAll();

    int update(Author author);

    int delete(int authorId);
}
