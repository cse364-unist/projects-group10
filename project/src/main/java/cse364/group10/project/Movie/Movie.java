package cse364.group10.project.Movie;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movie {
    private @id @GeneratedValue Long id;
    private String title;
    private String genre;
    private String discription;
    private float avgRating;
    private String tumbnail;

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
}
