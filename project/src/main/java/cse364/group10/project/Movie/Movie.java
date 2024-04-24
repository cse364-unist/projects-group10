package cse364.group10.project.Movie;

import java.util.Objects;
import java.util.List;

import cse364.group10.project.Review.Review;
import jakarta.persistence.*;

@Entity
public class Movie {
    private @id @GeneratedValue Long id;
    private String title;
    private String genre;
    private String discription;
    private float avgRating;
    private String tumbnail;
    @OneToMany(mappedBy = "movie")
    private List<Review> reviewList;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDiscription() {
        return discription;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public String getTumbnail() {
        return tumbnail;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setTumbnail(String tumbnail) {
        this.tumbnail = tumbnail;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
