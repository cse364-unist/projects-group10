package cse364.group10.project.Review;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies/{id}")
public class ReviewController {
    private final ReviewRepository repository;

    ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/reviews")
    List<Review> all() {
        return  repository.findAll();
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

    @GetMapping("/reviews")
    public List<Review> getReviewsForMovie(@RequestParam("movie") String movieName) {
        return repository.findByMoviename(movieName);
    }

    @PutMapping("/reviews/{reviewId}")
    Review replaceReview(@RequestBody Review newReview, @PathVariable Long reviewId) {
        return repository.findById(reviewId)
                .map(review -> {
                    review.setUsername(newReview.getUsername());
                    review.setMoviename(newReview.getMoviename());
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
