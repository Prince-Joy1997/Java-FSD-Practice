package in.stackroute.ust.service;

import in.stackroute.ust.domain.Review;
import in.stackroute.ust.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewByMovieId(int movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    @Override
    public List<Review> getReviewByReviewer(String reviewer) {
        return reviewRepository.findReviewByReviewer(reviewer);
    }
}
