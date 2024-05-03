package cse364.group10.project.Review;

public class ReviewNotFoundException extends RuntimeException {
    ReviewNotFoundException(Long id) {
        super("Could not find review " + id);
    }
}
