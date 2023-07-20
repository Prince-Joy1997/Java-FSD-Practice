package org.example;

import org.example.DAO.AuthorDAO;
import org.example.DAO.AuthorDAOImpl;
import org.example.DTO.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //insertData();
        //readAll();
        readById();
    }
    static void readAll(){
        AuthorDAO authorDao = new AuthorDAOImpl();
        List<Author> authors = authorDao.readAll();
        if(authors.isEmpty()){
            System.out.println("No authors found");
            return;
        }
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    static void readById() {
        AuthorDAO authorDao = new AuthorDAOImpl();
        Optional<Author> optionalAuthor = Optional.ofNullable(authorDao.read(1));
        if (optionalAuthor.isEmpty()) {
            System.out.println("Author not found");
            return;
        }
        System.out.println(optionalAuthor.get());
    }

    static void insertData() {
        Author tolkien = new Author(1, "J.R.R. Tolkien",
                "j.r.r.tolkien", LocalDate.of(1960, 10, 10));

        System.out.println("Saving author: " + tolkien);

        AuthorDAO authorDao = new AuthorDAOImpl();
        int updated = authorDao.create(tolkien);

        System.out.format("%d row(s) updated", updated);

    }

}