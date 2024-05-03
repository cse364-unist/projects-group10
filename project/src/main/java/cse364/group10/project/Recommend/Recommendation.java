package cse364.group10.project.Recommend;

import cse364.group10.project.Movie.Movie;
import cse364.group10.project.Movie.MovieRepository;
import cse364.group10.project.Review.ReviewController;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

@Service
public class Recommendation {
    private class EvaluatedMovie{
        Movie mov;
        int score;
        public EvaluatedMovie(Movie mov, int score){
            this.mov=mov;
            this.score=score;
        }
    }

    private class MovieComparator implements Comparator<EvaluatedMovie>{
        @Override
        public int compare(EvaluatedMovie m1, EvaluatedMovie m2){
            return m2.score-m1.score;
        }
    }

    private final MovieRepository MovieRepository;
    Random random = new Random();
    private final ReviewController ReviewsController;

    Recommendation(MovieRepository movieRepository, ReviewController reviewController){
        this.MovieRepository=movieRepository;
        this.ReviewsController=reviewController;
    }

    public List<Movie> RecommendExtract(HashMap<String,Integer> Prefer){
        List<Movie> Movies = MovieRepository.findAll();//영화 리스트 추가
        int size = Movies.size();
        PriorityQueue<EvaluatedMovie>pq = new PriorityQueue<EvaluatedMovie>(1, new MovieComparator());

        for(int i=0;i<size;i++){
            Movie movie = Movies.get(i);
            List<String> keywords = ReviewsController.extractKeywords(movie.getTitle());
            int score = 0;

            for(int j = 0; j<keywords.size(); j++){
                String keyword=keywords.get(j);
                if(Prefer.containsKey(keyword)) score += Prefer.get(keyword);
            }

            pq.offer(new EvaluatedMovie(movie, score));
        }

        List<Movie> sortMovies = new ArrayList<>();

        while(!pq.isEmpty()){
            sortMovies.add(pq.poll().mov);
        }

        return sortMovies;
    }

    public List<String> selectKeywords(int num){
        List<String> Keywords = new ArrayList<String>();
        for(int i=0;i<5;i++){
            String randId = String.valueOf(random.nextLong(3952)+1);
            Movie m = MovieRepository.findById(randId)
                .orElseThrow(() -> new RuntimeException("Not found Id!"));
            List<String> keyword = ReviewsController.extractKeywords(m.getTitle());
            Keywords.add(keyword.get(random.nextInt(keyword.size())));
        }
        return Keywords;
    }
}

