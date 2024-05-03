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
