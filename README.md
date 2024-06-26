# ReadMe Group 10

## How to run this program

docker build -t test .  //Build image

docker run --name app -it test  //Run container

mongod  //Run MongoDB

docker exec -it app /bin/bash  //Access bash

sh run.sh  //Execute run.sh

docker exec -it app /bin/bash  //Access bash




## Recommend

"We will provide a movie recommendation feature using the extracted keywords. We will select some of the extracted keywords and present them to the user, then receive their preference on them. Based on this preference, we will recommend movies."

#### getRecommends

```
@GetMapping("/recommends")
public List<String> getRecommends() {
    return Recommendation.selectKeywords(5);
}
```
When the client requests the recommendation page, we will select some of the keywords (5) and provide them to the client.
> Ex ) curl -X GET http://localhost:8080/recommends
> 
> Expected output: 5 random keywords will be returned.



---
#### getRecommendMovies
```
@GetMapping("/recommends")
public List<Movie> getRecommendMovies(@ModelAttribute KeywordScore KeywordScore) {
  HashMap<String,Integer> Keyword_Prefer = new HashMap<String,Integer>();

  for(int i=0; i<KeywordScore.getScore().size(); i++){
    Keyword_Prefer.put(KeywordScore.getKeywords().get(i), KeywordScore.getScore().get(i));
  }

  return Recommendation.RecommendExtract(Keyword_Prefer);
}
```
We receive keywords and their preferences from the client, then rate the movie preferences accordingly and provide the order based on them.
> Ex ) curl -X GET http://localhost:8080/recommends?Keywords=keyword1,keyword2,keyword3,keyword4,keyword5&Score=1,2,3,4,5
>
> Expected output : The movie priority based on preferred keywords is returned in the form of a List.

## Ratings for Genres

Each user can rate each movie in detail for each genre.

### Get Rating Informations

> $curl -X GET http://localhost:8080/ratings

 Get the all rating informations
 
> $curl -X GET http://localhost:8080/ratings/{movie}/{genre}

 Get ratings for the {movie}'s {genre}
 
> $curl -X GET http://localhost:8080/ratings/{movie}/{genre}/average

 Get average of ratings for the {movie}'s {genre}
 
---

### Add the Rating

> $curl -X POST http://localhost:8080/ratings -H 'Content-type:application/json' -d '{"userName":"James" "movieName":"The Movie(2000)", "ratings":"3.6", "rating1":"1.2", "rating2":"4.7", "rating3":"3.8", "rating4":"-1", "rating5":"-1"}'

Add the overall rating and ratings for each genre.

Rating of "-1" represents an empty genre compartment.

So, this command means "User, James, evaluate "The Movie(2000)" overall 3.6. And 1.2 for genre1(ex) Comedy), 4.7 for genre2, 3.8 for genre3."

---

## Extracting from Reviews

"We will extract keywords of a movie from reviews/"

### Get Review Information

> $curl -X GET http://localhost:8080/reviews

Get all reviews from a movie

> $curl -X GET http://localhost:8080/reviews?movie={movie}

Get keywords of a movie from reviews

> $curl -X GET http://localhost:8080/keywords?movie={movie}

ReviewController
```
@GetMapping("/keywords?movie={movie}")
public List<String> extractKeywords(@PathVariable String movie) {
    return extractor.extractKeywordsFromReviews(repository.findByMovie(movie));
}
```
KeyWordExtractor
```
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
```
### Add the review

> $curl -X POST http://localhost:8080/reviews -H 'Content-type:application/json' -d '{"user":"James" "movie":"UNIST(2007)", "rating":"3.6", "comments":"This is so amazing and wonderful!!! But 
The second half is boring."}'
