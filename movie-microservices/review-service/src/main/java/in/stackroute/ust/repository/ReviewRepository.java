package in.stackroute.ust.repository;

import in.stackroute.ust.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByMovieId(int id);

    List<Review> findReviewByReviewer(String reviewer);

}
