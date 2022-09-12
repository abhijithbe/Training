package org.example;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;

public class PostTweet {
    /**
     * The postTweet function is used to post the tweet of the user
     * it authenticate the user using keys and posts the tweet using updateStatus command
     * @param tweet -> Tweet message(status) that has to be posted
     * @param apiKey ->API Key for authentication
     * @param apiSecretKey ->API Secret Key for authentication
     * @param accessToken ->Access Key for authentication
     * @param accessSecretToken ->Access Secret Key for authentication
     */
    public static void postTweet(String tweet,String apiKey,String apiSecretKey,String accessToken,String accessSecretToken){

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(apiKey)
                    .setOAuthConsumerSecret(apiSecretKey)
                    .setOAuthAccessToken(accessToken)
                    .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            twitter.updateStatus(tweet);
            System.out.println("Successfully Tweeted");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}