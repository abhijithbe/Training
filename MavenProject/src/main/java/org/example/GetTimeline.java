package org.example;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


import java.util.List;

public class GetTimeline {
    /**
     * The getTimeline function basically authenticates the user using keys
     * it stores all the timeline tweets in the list data structure
     * it also prints the status(tweets) along with the name of the user
     * @param apiKey ->API Key for authentication
     * @param apiSecretKey ->API Secret key for authentication
     * @param accessToken ->Access key for authentication
     * @param accessSecretToken ->Access Secret key for authentication
     */
    public static void getTimeline(String apiKey,String apiSecretKey,String accessToken,String accessSecretToken)  {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try{
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" + status.getText());
            }
            System.out.println("Successfully Obtained Timeline");
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
