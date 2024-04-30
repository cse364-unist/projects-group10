package cse364.group10.project.Movie;

import java.util.Objects;
import java.util.List;

import cse364.group10.project.Review.Review;
import jakarta.persistence.*;

@Entity
public class Movie {
    private @Id @GeneratedValue Long id;
    private String title;
    private String genre;
    private String discription;
    private double avgRating;
    private String tumbnail;

    public Movie(String title, String genre, String discription, double avgRating, String tumbnail) {
        this.title = title;
        this.genre = genre;
        this.discription = discription;
        this.avgRating = avgRating;
        this.tumbnail = tumbnail;
    }
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

    public double getAvgRating() {
        return avgRating;
    }

    public String getTumbnail() {
        return tumbnail;
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

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setTumbnail(String tumbnail) {
        this.tumbnail = tumbnail;
    }

}
