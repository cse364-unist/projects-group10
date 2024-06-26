package cse364.group10.project.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MovieRepository extends  MongoRepository<Movie, String> {
    List<Movie> findByGenre(String genre);
}
