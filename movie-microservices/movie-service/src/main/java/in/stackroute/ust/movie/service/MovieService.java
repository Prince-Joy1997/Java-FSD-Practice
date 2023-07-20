package in.stackroute.ust.movie.service;

import in.stackroute.ust.movie.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Optional<Movie> findByTitle(String title);

    Optional<Movie> findByIdOrTitle(int id, String title);

    Movie create(Movie convertToEntity);

    List<Movie> findAll();

    Optional<Movie> findById(int id);

    Movie update(Movie movie);

    void delete(int id);
}
