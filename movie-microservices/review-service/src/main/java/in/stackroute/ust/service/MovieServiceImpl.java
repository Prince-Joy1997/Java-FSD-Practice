package in.stackroute.ust.service;

import in.stackroute.ust.dto.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private RestTemplate restTemplate;
    public MovieServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String url = "http://MOVIE-SERVICE/api/v1/movies/{id}";

    @Override
    public Optional<MovieDto> findById(int movieId) {
        try{
            final var response =  restTemplate.getForEntity(url, MovieDto.class, movieId);
            if(response.getStatusCode().is2xxSuccessful()){
                var body = response.getBody();
                return Optional.ofNullable(body);
            }
            return Optional.empty();
        }catch (Exception e){
            return Optional.empty();
        }
    }

}

