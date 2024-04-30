package cse364.group10.project.Review;

import cse364.group10.project.User.User;
import jakarta.persistence.*;

@Entity
public class Review {
    private @Id @GeneratedValue Long id;
    @OneToOne
    private User user;
    private double rating;
    private String comments;

    Review() {}

    Review(double rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }

}
