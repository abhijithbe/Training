package com.example.twittergraphql.PostTweet;
import com.example.twittergraphql.TimeLine.TimelineService;
import com.example.twittergraphql.Exceptions.TwitterExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
/**
 * the class is used to post the tweet
 * @author abhijith.be
 */
@Component
public class TweetPostService {
    /**
     * the method is accepts the tweet from user an posts the tweet
     * @param tweet -> user input tweet
     * @return -> status of the tweet
     * @throws TwitterExceptions
     */
    public String postStatus(String tweet) throws TwitterExceptions {
        TimelineService authObject=new TimelineService();
        ArrayList<String> keys=authObject.keysExtraction();
        String status=postTweet(tweet,keys.get(0), keys.get(1), keys.get(2), keys.get(3));
        return status;
    }
    /**
     * The postTweet function is used to post the tweet of the user
     * it authenticate the user using keys and posts the tweet using updateStatus command
     * @param tweet -> Tweet message(status) that has to be posted
     * @param apiKey ->API Key for authentication
     * @param apiSecretKey ->API Secret Key for authentication
     * @param accessToken ->Access Key for authentication
     * @param accessSecretToken ->Access Secret Key for authentication
     */
    public static String postTweet(String tweet,String apiKey,String apiSecretKey,String accessToken,String accessSecretToken) throws TwitterExceptions {
        Logger logger = LoggerFactory.getLogger(TweetPostService.class);
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();
        logger.debug("Authenticated the User");
        try
        {
            twitter.updateStatus(tweet);
            logger.info("Tweet Successful");
            return "Success";
        }
        catch (TwitterException e)
        {
            throw new TwitterExceptions("User Not Authenticated");
        }

    }
}
