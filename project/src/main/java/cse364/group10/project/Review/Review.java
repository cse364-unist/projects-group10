package cse364.group10.project.Review;

import cse364.group10.project.User.User;
import jakarta.persistence.*;

@Entity
public class Review {
    private @Id @GeneratedValue Long id;
    private String username;
    private String moviename;
    private double rating;
    private String comments;

    Review() {}

    Review(String username, String moviename, double rating, String comments) {
        this.username = username;
        this.moviename = moviename;
        this.rating = rating;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMoviename() {
        return moviename;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }

}
