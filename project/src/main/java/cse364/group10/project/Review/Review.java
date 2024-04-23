package cse364.group10.project.Review;

import cse364.group10.project.Users.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {
    @id @GeneratedValue
    private Long id;
    private Users user;
    private double rating;
    private String comments;

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
}
