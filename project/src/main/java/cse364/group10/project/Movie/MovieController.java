package cse364.group10.project.Movie;

import java.util.List;
import cse364.group10.project.Review.Review;
import cse364.group10.project.Movie.KeywordExtract.KeyWordExtractor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieRepository repository;

    private final KeyWordExtractor extractor;

    MovieController(MovieRepository repository, KeyWordExtractor extractor) {
        this.repository = repository;
        this.extractor = extractor;
    }

    @GetMapping("/movies")
    List<Movie> all() {
        return repository.findAll();
    }

    @PostMapping("movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
    }

    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    /*@GetMapping("/movies?genre={genre}")
    List<Movie> findByGenre(@PathVariable String genre) {
        return repository.findByGenre(genre);
    }*/

    @GetMapping("/movies/{id}/reviews")
    List<Review> getReviewsForMovie(@PathVariable Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return movie.getReviewList();
    }

    @GetMapping("/movies/{id}/reviews/keywords")
    List<String> getKeywordsFromReviews(@PathVariable Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return extractor.extractKeywordsFromReviews(movie.getReviewList());
    }

    @PutMapping("/movies/{id}")
    Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {
        return repository.findById(id)
                .map(movie -> {
                    movie.setAvgRating(newMovie.getAvgRating());
                    movie.setDiscription(newMovie.getDiscription());
                    movie.setGenre(newMovie.getGenre());
                    movie.setTitle(newMovie.getTitle());
                    movie.setTumbnail(newMovie.getTumbnail());
                    return repository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
