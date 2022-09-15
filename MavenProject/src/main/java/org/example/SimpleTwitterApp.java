package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
/**
 * the class extracts the keys and gives choices to user to either get timeline or post a tweet
 * @author abhijith.be
 */
public class SimpleTwitterApp {
    static Logger logger = LoggerFactory.getLogger(SimpleTwitterApp.class);
    /**
     * to extract the keys from the properties file
     * @return -> the array of string with extracted keys
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> keysExtraction()  {
        FileReader twitterKeys= null;
        try {
            twitterKeys = new FileReader("/Users/abhijith.be/Desktop/Training/MavenProject/src/main/java/org/example/twitter.properties");
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
     * to obtain the choice of selection from the user
     * @return -> the choice obtained from user
     */
    public int getChoice()
    {
        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();
        return choice;
    }
    /**
     * to obtain the tweet as input from the user
     * @return -> the tweet obtained from user
     */
    public String getTweet()
    {
        logger.info("Enter the Tweet to Post");
        Scanner inputScanner = new Scanner(System.in);
        String tweet = inputScanner.next();
        return tweet;
    }

    /**
     * performes the operations based on user choice
     * operations-> post the tweet,get home timeline of user
     */
    public void performAction()
    {
        SimpleTwitterApp twitterObject = new SimpleTwitterApp();
        ArrayList<String> twitterKeys = twitterObject.keysExtraction();
        boolean flag = true;
        while(flag)
        {
            logger.info("Enter the Choice");
            logger.info("1.Post a Tweet");
            logger.info("2.Get Home TimeLines");
            logger.info("3.Exit");
            int choice = twitterObject.getChoice();
            logger.debug("Choice taken",choice);
            if(choice == 3)
            {
                logger.debug("Exit choice selected",choice);
                break;
            }
            switch (choice)
            {
                case 1:
                    String tweetMessage = twitterObject.getTweet();
                    TwitterPost postObject = new TwitterPost();
                    postObject.postTweet(tweetMessage,twitterKeys.get(0),twitterKeys.get(1),twitterKeys.get(2),twitterKeys.get(3));
                    logger.info("PostTweet Called");
                    break;
                case 2:
                    Timeline timelineObject = new Timeline();
                    timelineObject.getTimeline(twitterKeys.get(0),twitterKeys.get(1),twitterKeys.get(2),twitterKeys.get(3));
                    logger.info("Timeline Called");
                    break;
                default:
                    logger.info("Nothing called because of wrong choice");
                    break;
            }
        }
    }
    public static void main(String args[]) throws IOException
    {
        SimpleTwitterApp twitterObject = new SimpleTwitterApp();
        twitterObject.performAction();
        logger.info("Action Performed");
    }
}
