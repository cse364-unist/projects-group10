package cse364.group10.project.Review;

public class ReviewNotFoundException extends RuntimeException {
    ReviewNotFoundException(String id) {
        super("Could not find review " + id);
    }
}
