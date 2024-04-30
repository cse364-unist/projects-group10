package cse364.group10.project.Movie.KeywordExtract;

import cse364.group10.project.Review.Review;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyWordExtractor {
    public List<String> extractKeywordsFromReviews(List<Review> reviews) {
        List<String> keywords = new ArrayList<>();

        for (Review review : reviews) {
            List<String> words = extractWords((review.getComments()));
            keywords.addAll(words);
        }

        return keywords;
    }

    List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }
}
