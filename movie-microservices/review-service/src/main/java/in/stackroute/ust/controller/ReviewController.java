package in.stackroute.ust.controller;

import in.stackroute.ust.domain.Review;
import in.stackroute.ust.dto.ReviewDto;
import in.stackroute.ust.service.CustomerService;
import in.stackroute.ust.service.MovieService;
import in.stackroute.ust.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto){
        var reviewEntity = toEntity(reviewDto);
        var movie = movieService.findById(reviewDto.movieId());
        var customer = customerService.findByEmail(reviewDto.reviewer());
        if (movie.isEmpty() || customer.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var createdReview = reviewService.createReview(reviewEntity);
        return ResponseEntity.ok(toDto(createdReview));
    }

    @GetMapping("/id/{movieId}")
    public ResponseEntity<List<ReviewDto>> getReviewByMovieId(@PathVariable int movieId) {
        var review = reviewService.getReviewByMovieId(movieId);
        if (review.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review.stream().map(this::toDto).toList());
    }

    @GetMapping("/reviewer/{reviewer}")
    public ResponseEntity<List<ReviewDto>> getReviewByReviewer(@PathVariable String reviewer) {
        var review = reviewService.getReviewByReviewer(reviewer);
        if (review.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review.stream().map(this::toDto).toList());
    }


    private Review toEntity(ReviewDto reviewDto) {
        return new Review(reviewDto.movieId(), reviewDto.review(), reviewDto.reviewer(), reviewDto.rating());
    }

    private ReviewDto toDto(Review review) {
        return new ReviewDto(review.getMovieId(), review.getReview(), review.getReviewer(), review.getRating());
    }


}
