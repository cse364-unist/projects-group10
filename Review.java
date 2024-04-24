package cse364.group10.project.Review;

import cse364.group10.project.Movie.Movie;
import cse364.group10.project.Users.Users;
import jakarta.persistence.*;

@Entity
public class Review {
    @id @GeneratedValue
    private Long id;
    @OneToOne
    private Users user;
    private double rating;
    private String comments;
    @ManyToOne
    private Movie movie;

    public Long getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public Users getUser() {
        return user;
    }

    public String getComments() {
        return comments;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
