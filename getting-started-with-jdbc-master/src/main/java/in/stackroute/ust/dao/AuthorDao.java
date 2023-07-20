package in.stackroute.ust.dao;

import in.stackroute.ust.dto.Author;

public interface AuthorDao {
    
    // Methods to perform CRUD operations on Author table

    int create(Author author);

    Author read(int authorId);

    int update(Author author);

    int delete(int authorId);

}
