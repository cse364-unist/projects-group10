package cse364.group10.project.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByMovieName(String movieName);
    List<Rating> findByGenreName(String genre);
}
