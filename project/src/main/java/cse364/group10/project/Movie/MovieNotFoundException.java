package cse364.group10.project.Movie;

public class MovieNotFoundException extends RuntimeException {
    MovieNotFoundException(String id) {
        super("Cound not find movie " + id);
    }
}
