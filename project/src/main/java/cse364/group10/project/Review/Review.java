package cse364.group10.project.Review;

import cse364.group10.project.User.User;
import jakarta.persistence.*;

@Entity
public class Review {
    private @Id @GeneratedValue Long id;
    private String user;
    private String movie;
    private double rating;
    private String comments;

    Review() {}

    Review(String user, String movie, double rating, String comments) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getMovie() {
        return movie;
    }

    public double getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }

}
