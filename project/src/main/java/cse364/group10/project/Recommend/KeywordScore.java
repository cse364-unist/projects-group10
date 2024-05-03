package cse364.group10.project.Recommend;

import java.util.List;


public class KeywordScore {
    List<String> Keywords;
    List<Integer> Score;

    public List<String> getKeywords(){
        return Keywords;
    }

    public List<Integer> getScore(){
        return Score;
    }

    public void setKeywords(List<String> Keywords){
        this.Keywords=Keywords;
    }

    public void setScore(List<Integer> Score){
        this.Score=Score;
    }
}
