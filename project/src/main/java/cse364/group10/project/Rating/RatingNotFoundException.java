package cse364.group10.project.Rating;

public class RatingNotFoundException extends RuntimeException {
    RatingNotFoundException(Long id) {
        super("Could not find rating " + id);
    }
}
