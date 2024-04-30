package cse364.group10.project.Review;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ReviewNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReviewNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reviewNotFoundHandler(ReviewNotFoundException ex) {
        return ex.getMessage();
    }

}
