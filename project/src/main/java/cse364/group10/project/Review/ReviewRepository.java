package cse364.group10.project.Review;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMoviename(String movieName);
    List<Review> findByUnsername(String userName);
}
