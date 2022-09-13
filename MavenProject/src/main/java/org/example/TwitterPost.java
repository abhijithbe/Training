package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * the class is used to post the tweet
 * @author abhijith.be
 */
public class TwitterPost {
    /**
     * The postTweet function is used to post the tweet of the user
     * it authenticate the user using keys and posts the tweet using updateStatus command
     * @param tweet -> Tweet message(status) that has to be posted
     * @param apiKey ->API Key for authentication
     * @param apiSecretKey ->API Secret Key for authentication
     * @param accessToken ->Access Key for authentication
     * @param accessSecretToken ->Access Secret Key for authentication
     */
    public static void postTweet(String tweet,String apiKey,String apiSecretKey,String accessToken,String accessSecretToken)
    {
        Logger logger = LoggerFactory.getLogger(SimpleTwitterApp.class);
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
            twitter.updateStatus(tweet);
            logger.info("Tweet Successful");
        }
        catch (TwitterException e)
        {
            logger.debug("Tweet Incomplete due to exception",e);
        }

    }
}