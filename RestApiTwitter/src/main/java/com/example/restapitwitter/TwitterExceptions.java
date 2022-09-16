package com.example.restapitwitter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import twitter4j.TwitterException;

/**
 * The class creates customized exceptions for Twitter
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class TwitterExceptions extends TwitterException {
    public TwitterExceptions(String message) {
        super(message);
    }
}
