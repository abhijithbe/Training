package com.example.restapitwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * Controller is used to interact with Service layer and get the get and post results
 */
@RestController
public class Controller {
    @Autowired
    TimelineService timelineObject;
    @Autowired
    TweetPostService postObject;
    /**
     * timeline function is get mapping and gathers the timeline from Timeline Service Layer
     * @return -> timeline of the user
     * @throws TwitterExceptions
     */
    @GetMapping("/api/1.0/twitter/tweet")
    public List<Status> timeLine() throws TwitterExceptions {

        List<Status> timeline=timelineObject.returnTimeline();
        return timeline;
    }
    /**
     * posttweet is used for post mapping and to post the tweet
     * @param tweet -> tweet to be posted
     * @return -> status of post
     * @throws TwitterExceptions
     */
    @PostMapping("/api/1.0/twitter/post")
    public String postTweet(@RequestBody String tweet) throws TwitterExceptions {
        String status=postObject.postStatus(tweet);
        return status;
    }
}
