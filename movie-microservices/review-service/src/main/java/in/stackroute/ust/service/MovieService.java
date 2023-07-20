package in.stackroute.ust.service;

import in.stackroute.ust.dto.MovieDto;

import java.util.Optional;

public interface MovieService {
    Optional<MovieDto> findById(int movieId);
}
