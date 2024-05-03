package cse364.group10.project.Rating;

import java.util.List;
import cse364.group10.project.Rating.EvaluateGenre.EvaluateGenre;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies/{id}")
public class RatingController {
    private final RatingRepository repository;
    private final EvaluateGenre evaluate;

    RatingController(RatingRepository repository, EvaluateGenre evaluate) {
        this.repository = repository;
        this.evaluate = evaluate
    }

    @GetMapping("/ratings")
    List<Rating> all() {
        return repository.findAll();
    }
    
    @GetMapping("/reviews/{movie}/{genre}")
    public List<Integer> genreEvaluate(@RequestParam("movie") String movieName, @PathVariable("genre") String genre) {
        return evaluate.findGenreRatings(repository.findByMovieName(movieName), genre);
    }
    @GetMapping("/reviews/{movie}/{genre}/average")
    public List<Integer> genreEvaluateAvg(@RequestParam("movie") String movieName, @PathVariable("genre") String genre) {
        return evaluate.genreRatingAvg(evaluate.findGenreRatings(repository.findByMovieName(movieName), genre));
    }

    @PostMapping("/ratings")
    Rating newRating(@RequestBody Rating newRating) {
        return repository.save(newRating);
    }

    @GetMapping("/ratings/{ratingId}")
    Rating one(@PathVariable Long ratingId) {
        return repository.findById(ratingId)
                .orElseThrow(() -> new RatingNotFoundException(ratingId));
    }

    @PutMapping("/ratings/{ratingId}")
    Rating replaceRating(@RequestBody Rating newRating, @PathVariable Long ratingId) {
        return repository.findById(ratingId)
                .map(rating -> {
                    rating.setUserName(newRating.getUserName());
                    rating.setMovieName(newRating.getMovieName());
                    rating.setRating(newRating.getRating());
                    
                    rating.setRatingGenre(newRating.getRatingGenre(0), 0);
                    rating.setRatingGenre(newRating.getRatingGenre(1), 1);
                    rating.setRatingGenre(newRating.getRatingGenre(2), 2);
                    rating.setRatingGenre(newRating.getRatingGenre(3), 3);
                    rating.setRatingGenre(newRating.getRatingGenre(4), 4);
                    
                    return repository.save(rating);
                })
                .orElseGet(() -> {
                    newRating.setId(ratingId);
                    return  repository.save(newRating);
                });
    }

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable Long ratingId) {
        repository.deleteById(ratingId);
    }
}
