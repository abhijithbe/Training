package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;
/**
 * the class obtain the user hometimeline
 * @author abhijith.be
 */
public class Timeline {
    static  Logger logger = LoggerFactory.getLogger(Timeline.class);
    /**
     * the function prints all the home time line of the user
     * @param statuses -> list of status of hometimeline
     */
    public void printStatus(List<Status> statuses)
    {
        logger.info("Showing Timeline");
        for (Status status : statuses)
        {
            logger.debug("Username",status.getUser().getName());
            logger.info(status.getText());
        }
        logger.info("Successfully Obtained Timeline");
    }
    /**
     * The getTimeline function basically authenticates the user using keys
     * it stores all the timeline tweets in the list data structure
     * it also prints the status(tweets) along with the name of the user
     * @param apiKey ->API Key for authentication
     * @param apiSecretKey ->API Secret key for authentication
     * @param accessToken ->Access key for authentication
     * @param accessSecretToken ->Access Secret key for authentication
     */
    public static void getTimeline(String apiKey,String apiSecretKey,String accessToken,String accessSecretToken)
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();
        logger.info("Authenticated the User");
        try
        {
            List<Status> statuses = twitter.getHomeTimeline();
            Timeline timelineObject = new Timeline();
            timelineObject.printStatus(statuses);
            logger.info("Tweet Successful");
        }
        catch(TwitterException e)
        {
            logger.debug("Tweet Incomplete due to exception",e);
        }

    }
}
