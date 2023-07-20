package in.stackroute.springrestjpacodingchallenge.repository;

import in.stackroute.springrestjpacodingchallenge.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    
}
