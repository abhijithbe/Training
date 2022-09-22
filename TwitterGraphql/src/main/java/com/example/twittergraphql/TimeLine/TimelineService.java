package com.example.twittergraphql.TimeLine;
import com.example.twittergraphql.Exceptions.TwitterExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
/**
 * the class is used to obtain hometimeline of the user
 * @author abhijith.be
 */
@Component
public class TimelineService {
    static  Logger logger = LoggerFactory.getLogger(TimelineService.class);
    /**
     * The methods used to extract keys from properties file
     * @return -> extracted keys
     */
    public static ArrayList<String> keysExtraction()  {
        FileReader twitterKeys= null;
        try {
            twitterKeys = new FileReader("/Users/abhijith.be/Desktop/Training/TwitterGraphql/src/main/java/com/example/twittergraphql/twitter.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties fileProperties = new Properties();
        try {
            fileProperties.load(twitterKeys);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("No Exceptions Occured");
        ArrayList<String> twitterAuthkeys = new ArrayList<String>();
        String apiKey = fileProperties.getProperty("apikey");
        String apiSecretKey = fileProperties.getProperty("apisecretkey");
        String accessKey = fileProperties.getProperty("accesstoken");
        String accessSecretKey = fileProperties.getProperty("accesssecrettoken");
        twitterAuthkeys.add(apiKey);
        twitterAuthkeys.add(apiSecretKey);
        twitterAuthkeys.add(accessKey);
        twitterAuthkeys.add(accessSecretKey);
        return twitterAuthkeys;
    }
    /**
     * the method returns the status of hometimeline
     * @return -> status of timeline
     * @throws TwitterExceptions
     */
    public List<Status> returnTimeline() throws TwitterExceptions {
        ArrayList<String> keys= keysExtraction();
        List<Status> status=getTimeline(keys.get(0),keys.get(1),keys.get(2),keys.get(3));
        return status;

    }
    /**
     * the function prints all the home time line of the user
     * @param statuses -> list of status of home timeline
     */
    public void printStatus(List<Status> statuses)
    {
        logger.info("Showing Timeline");
        for (Status status : statuses)
        {
            logger.info("Username",status.getUser().getName());
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
    public static List<Status> getTimeline(String apiKey, String apiSecretKey, String accessToken, String accessSecretToken) throws TwitterExceptions {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();
        HashMap<String,String> map =new HashMap<>();
        try
        {
            List<Status> statuses = twitter.getHomeTimeline();
            TimelineService timelineServiceObject = new TimelineService();
            timelineServiceObject.printStatus(statuses);
            logger.info("Tweet Successful");
            return statuses;
        }
        catch(TwitterException e)
        {
            throw new TwitterExceptions("User Not Authenticated");
        }

    }
}
