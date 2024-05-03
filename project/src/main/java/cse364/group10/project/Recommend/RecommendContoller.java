package cse364.group10.project.Recommend;

import org.springframework.web.bind.annotation.*;

import cse364.group10.project.Movie.Movie;

import java.util.HashMap;
import java.util.List;


@RestController
public class RecommendContoller {
    private final Recommendation Recommendation;

    RecommendContoller(Recommendation Recommendation){
        this.Recommendation=Recommendation;
    }

    @GetMapping("/recommends")
    public List<String> getRecommends() {
        return Recommendation.selectKeywords(5);
    }

    @GetMapping("/recommends")
    public List<Movie> getMethodName(@ModelAttribute KeywordScore KeywordScore) {
        HashMap<String,Integer> Keyword_Prefer = new HashMap<String,Integer>();

        for(int i=0; i<KeywordScore.getScore().size(); i++){
            Keyword_Prefer.put(KeywordScore.getKeywords().get(i), KeywordScore.getScore().get(i));
        }

        return Recommendation.RecommendExtract(Keyword_Prefer);
    }
    
    
}
