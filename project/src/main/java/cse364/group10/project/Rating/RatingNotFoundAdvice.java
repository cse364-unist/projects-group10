package cse364.group10.project.Rating;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RatingNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RatingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ratingNotFoundHandler(RatingNotFoundException ex) {
        return ex.getMessage();
    }

}
