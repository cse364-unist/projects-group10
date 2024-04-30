package cse364.group10.project.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;

public interface MovieRepository extends  JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
}
