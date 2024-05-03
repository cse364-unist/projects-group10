package cse364.group10.project.Rating;

import cse364.group10.project.User.User;
import jakarta.persistence.*;

@Entity
public class Rating {
    private @Id @GeneratedValue Long id;
    @OneToOne
    private User user;
    private String userName;
    private String movieName;
    private String[] genreName = { "None", "None", "None", "None", "None" };
    private int genreNum = 0;
    private double rating;
    private double[] ratingGenre = { -1, -1, -1, -1, -1 };

    Rating() {}

    Rating(double rating) {
        this.rating = rating;
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public double getRating() { return rating; }
    public String getUserName() { return userName; }
    public String getMovieName() { return movieName; }
    public String getGenreName(int n) { return genreName[n]; }
    public double getRatingGenre(int n) { return ratingGenre[n]; }
    public int getRatingGenreNum() { return genreNum; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setRating(double rating) { this.rating = rating; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }
    public void setGenreName(String genreName) {
        if (genreNum < 5){
            this.genreName[this.genreNum] = genreName;
            genreNum++;
        }
    }
    public void setRatingGenre(double rating, int n) {
        if (n < 5) this.ratingGenre[n] = rating;
    }
}
