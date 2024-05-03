package cse364.group10.project.Rating.EvaluateGenre;

import cse364.group10.project.Rating.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EvaluateGenre {
    public List<String> genreEvaluate(List<Rating> ratings, String genre) {
        List<Double> ratingsForGenre = new ArrayList<>();
        for (Rating rating : ratings) {
            for (int i = 0; i < rating.getRatingGenreNum(); i++){
                if (genre == rating.getGenreName(i))
                    List<Double> score = rating.getRatingGenre(i);
                    ratingsForGenre.addAll(score);
            }
        }

        return ratingsForGenre;
    }

    public double genreRatingAvg(List<Double> ratings) {
        double sum = 0;
        int i = 0;
        for (double rating: ratings){
            sum += rating;
            i++;
        }
        
        return sum / i;
    }
}
