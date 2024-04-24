package cse364.group10.project.Review;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private final ReviewRepository repository;

    ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reviews")
    List<Review> all() {
        return  repository.findAll();
    }

    @PostMapping("/reviews")
    Review newReview(@RequestBody Review newReview) {
        return repository.save(newReview);
    }

    @GetMapping("/reviews/{id}")
    Review one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @PutMapping("/reviews/{id}")
    Review replaceReview(@RequestBody Review newReview, @PathVariable Long id) {
        return repository.findById(id)
                .map(review -> {
                    review.setComments(newReview.getComments());
                    review.setRating(newReview.getRating());
                    review.setUser(newReview.getUser());
                    return repository.save(review);
                })
                .orElseGet(() -> {
                    newReview.setId(id);
                    return  repository.save(newReview);
                });
    }

    @DeleteMapping("/reviews/{id}")
    void deleteReview(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
