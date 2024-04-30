package cse364.group10.project.Review;

import java.util.List;

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

    @PutMapping("/reviews/{reviewId}")
    Review replaceReview(@RequestBody Review newReview, @PathVariable Long reviewId) {
        return repository.findById(reviewId)
                .map(review -> {
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
