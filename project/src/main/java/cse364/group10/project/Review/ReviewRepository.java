package cse364.group10.project.Review;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, Long> {
    List<Review> findByMovie(String movie);
    List<Review> findByUser(String user);
}
