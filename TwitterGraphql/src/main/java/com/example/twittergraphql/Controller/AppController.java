package com.example.twittergraphql.Controller;
import com.example.twittergraphql.Exceptions.TwitterExceptions;
import com.example.twittergraphql.PostTweet.Inputmsgs;
import com.example.twittergraphql.PostTweet.TweetPostService;
import com.example.twittergraphql.TimeLine.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * AppController is used to interact with Service layer and get the get and post results
 * @author abhijith.be
 */
@Controller
public class AppController {
    @Autowired
    TimelineService timelineObject;
    @Autowired
    TweetPostService postObject;
    /**
     * to fetch the data below function is used
     * @return -> fetched status of used
     * @throws TwitterExceptions
     */
    @QueryMapping("getTimeline")
    public List<Status> getTimeline() throws TwitterExceptions {
        List<Status> val=timelineObject.returnTimeline();
        return val;
    }
    /**
     * to post the data below method is used
     * @param msg -> data to be posted
     * @return -> success on post
     * @throws TwitterExceptions
     */
    @MutationMapping("postTweet")
    public String postTweets(@Argument Inputmsgs msg) throws TwitterExceptions {
        postObject.postStatus(msg.getMsg());
        return "success";
    }
}
