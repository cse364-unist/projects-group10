package cse364.group10.project.Review;

import cse364.group10.project.Review.KeywordExtract.KeyWordExtractor;
import java.util.List;

import cse364.group10.project.Review.KeywordExtract.KeyWordExtractor;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    private final ReviewRepository repository;
    private final KeyWordExtractor extractor;

    ReviewController(ReviewRepository repository, KeyWordExtractor extractor) {
        this.repository = repository;
        this.extractor = extractor;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/reviews")
    List<Review> all() {
        return  repository.findAll();
    }

    @GetMapping("/reviews/{movie}")
    public List<Review> getReviewsForMovie(@PathVariable("movie") String movie) {
        return repository.findByMovie(movie);
    }

    @GetMapping("/reviews/{user}")
    public List<Review> getReviewsWrittenByUser(@PathVariable("user") String user) {
        return repository.findByUser(user);
    }

    @GetMapping("/reviews/{movie}/keywords")
    public List<String> extractKeywords(@PathVariable("movie") String movie) {
        return extractor.extractKeywordsFromReviews(repository.findByMovie(movie));
    }

    // end::get-aggregate-root[]

    @PostMapping("/reviews")
    Review newReview(@RequestBody Review newReview) {
        return repository.save(newReview);
    }

    @GetMapping("/reviews/{reviewId}")
    Review one(@PathVariable Long reviewId) {
        return repository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));
    }

    @PutMapping("/reviews/{reviewId}")
    Review replaceReview(@RequestBody Review newReview, @PathVariable Long reviewId) {
        return repository.findById(reviewId)
                .map(review -> {
                    review.setUser(newReview.getUser());
                    review.setMovie(newReview.getMovie());
                    review.setComments(newReview.getComments());
                    review.setRating(newReview.getRating());
                    return repository.save(review);
                })
                .orElseGet(() -> {
                    newReview.setId(reviewId);
                    return  repository.save(newReview);
                });
    }

    @DeleteMapping("/reviews/{reviewId}")
    void deleteReview(@PathVariable Long reviewId) {
        repository.deleteById(reviewId);
    }
}
