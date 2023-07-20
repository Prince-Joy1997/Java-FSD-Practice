package in.stackroute.ust.movie.controller;

import in.stackroute.ust.movie.domain.Movie;
import in.stackroute.ust.movie.dto.MovieDto;
import in.stackroute.ust.movie.exception.MovieAlreadyExistException;
import in.stackroute.ust.movie.exception.MovieNotFoundException;
import in.stackroute.ust.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    private MovieDto covertDto(Movie movie) {
        return new MovieDto(movie.getId(), movie.getTitle());
    }

    private Movie convertToEntity(MovieDto movieDto) {
        return new Movie(movieDto.id(), movieDto.title());
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto) {
        logger.info("createMovie: Creating movie with title {}", movieDto.title());
        Optional<Movie> movie = movieService.findByIdOrTitle(movieDto.id(), movieDto.title());
        if (movie.isPresent()) {
            logger.error("createMovie: Movie with id {} or title {} already exists", movieDto.id(), movieDto.title());
            throw new MovieAlreadyExistException(String.format("Movie with id %d or title %s already exists", movieDto.id(), movieDto.title()), ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
        }
        Movie res = movieService.create(convertToEntity(movieDto));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(res.getId()).toUri()).body(covertDto(res));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        logger.info("getAllMovies: Fetching all movies");
        var list = movieService.findAll();
        if (list.isEmpty()) {
            logger.error("getAllMovies: No movies found");
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found"),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(list.stream().map(this::covertDto).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") int id) {
        logger.info("getMovie: Fetching movie with id {}", id);
        var optional = movieService.findById(id);
        if (optional.isEmpty()) {
            logger.error("getMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(covertDto(optional.get()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") int id, @RequestBody MovieDto movieDto) {
        logger.info("updateMovie: Updating movie with id {}", id);
        var optional = movieService.findById(id);
        if (optional.isEmpty()) {
            logger.error("updateMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        Movie movie = optional.get();
        movie.setTitle(movieDto.title());
        movie = movieService.update(movie);
        return ResponseEntity.ok(covertDto(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") int id) {
        logger.info("deleteMovie: Deleting movie with id {}", id);
        var optional = movieService.findById(id);
        if (optional.isEmpty()) {
            logger.error("deleteMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        movieService.delete(optional.get().getId());
        return ResponseEntity.noContent().build();
    }

}
