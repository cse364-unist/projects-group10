package cse364.group10.project.Movie;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private  final MovieRepository repository;

    MovieController(MovieRepository repository) {
        this.repository = repository;
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
    Movie one(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @GetMapping("/movies?genre={genre}")
    List<Movie> findByGenre(@PathVariable String genre) {
        return repository.findByGenre(genre);
    }

    @PutMapping("/movies/{id}")
    Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable String id) {
        return repository.findById(id)
                .map(movie -> {
                    movie.setAvgRating(newMovie.getAvgRating());
                    movie.setDescription(newMovie.getDescription());
                    movie.setGenre(newMovie.getGenre());
                    movie.setTitle(newMovie.getTitle());
                    movie.setThumbnail(newMovie.getTumbnail());
                    return repository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable String id) {
        repository.deleteById(id);
    }
}
