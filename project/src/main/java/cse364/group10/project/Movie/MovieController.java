package cse364.group10.project.Movie;

import java.util.List;

import cse364.group10.project.Review.KeywordExtract.KeyWordExtractor;

import cse364.group10.project.Review.ReviewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private final MovieRepository repository;

    MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    List<Movie> all() {
        return repository.findAll();
    }

    @PostMapping("/movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
    }

    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @GetMapping("/movies")
    List<Movie> findByGenre(@RequestParam("genre") String genre) {
        return repository.findByGenre(genre);
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

    @GetMapping("/movies/{genre}")
    List<Movie> getMoviesWithGenre(@PathVariable("genre") String genre) {
        return repository.findByGenre(genre);
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
