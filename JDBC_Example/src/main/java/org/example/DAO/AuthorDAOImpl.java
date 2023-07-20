package org.example.DAO;

import org.example.DTO.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO{

    private static final String INSERT_QUERY = """
                                                    INSERT INTO AUTHORS
                                                    (AUTHOR_ID,AUTHOR_NAME,AUTHOR_EMAIL,JOIN_DATE) 
                                                    VALUES (?,?,?,?)""";
    private static final String READ_BY_ID = "SELECT * FROM AUTHORS WHERE AUTHOR_ID = ?";
    private static final String READ_ALL = " SELECT * FROM AUTHORS ";
    private static final String UPDATE_QUERY = """
            UPDATE AUTHORS
            SET AUTHOR_NAME = ?,
            AUTHOR_EMAIL = ?, JOIN_DATE = ?
            WHERE AUTHOR_ID = ?
            """;

    private static final String DELETE_QUERY = " DELETE FROM AUTHORS WHERE AUTHOR_ID = ? ";


    @Override
    public int create(Author author) {
        int updated = 0;
        try (var connection = DBConnection.getConnection();
             var prepareStatement = connection.prepareStatement(INSERT_QUERY)){

            // disabling the auto commit feature of the JDBC Connection
            connection.setAutoCommit(false);

            prepareStatement.setInt(1, author.authorId());
            prepareStatement.setString(2, author.authorName());
            prepareStatement.setString(3, author.authorEmail());
            prepareStatement.setDate(4, Date.valueOf(author.joinDate()));
            // prepareStatement.setObject(5, author.getJoinDate());

            updated = prepareStatement.executeUpdate();
            // commit the changes to the database
            connection.commit();

        } catch (SQLException e) {
            System.err.println("Error while connecting to database");
            System.err.println(e.getMessage());
        }
        return updated;

    }

    @Override
    public Author read(int authorId) {
        Author author = null;
        try (
                var  connection = DBConnection.getConnection();
                var prepareStatement = connection.prepareStatement(READ_BY_ID)

        ) {

            prepareStatement.setInt(1, authorId);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                author = new Author(

                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDate(4).toLocalDate()

                );
            }
        } catch (SQLException e) {
            System.err.println("Error while connecting to database");
            System.err.println(e.getMessage());
        }
        return author;

    }

    @Override
    public List<Author> readAll() {

        List<Author> authors = new ArrayList<>();
        try (
                var connection = DBConnection.getConnection();
                var prepareStatement = connection.prepareStatement(READ_ALL)

                ) {

            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDate(4).toLocalDate()

                );
                authors.add(author);
            }
            prepareStatement.close();
        }catch (SQLException e) {
            System.err.println("Error while connecting to database");
            System.err.println(e.getMessage());
        }
        return authors;
    }



    @Override
    public int update(Author author) {
        return 0;
    }

    @Override
    public int delete(int authorId) {
        return 0;
    }
}
